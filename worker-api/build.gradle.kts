plugins {
	base
}

interface ReverseParams: WorkParameters {
	val fileToReverse: RegularFileProperty
	val destDir: DirectoryProperty
}

abstract class ReverseFile @Inject constructor(
	val fileSystemOperations: FileSystemOperations
): WorkAction<ReverseParams> {
	override fun execute() {
		println("started ${this} ${System.currentTimeMillis()}")
		fileSystemOperations.copy {
			from(parameters.fileToReverse)
			into(parameters.destDir)
			filter { line: String -> line.reversed() }
		}
		Thread.sleep(2000)
		println("finished ${this} ${System.currentTimeMillis()}")
	}
}

abstract class ReverseFiles @Inject constructor(
	private val exec: WorkerExecutor
): SourceTask() {
	@get: OutputDirectory
	abstract val outputDir: DirectoryProperty

	@TaskAction
	fun reverseFiles() {
		val queue = exec.processIsolation() {
			forkOptions {
				maxHeapSize = "512m"
			}
		}

		source.forEach { file ->
			queue.submit(ReverseFile::class) {
				fileToReverse.set(file)
				destDir.set(outputDir)
			}
		}

		queue.await()
		logger.lifecycle("Created ${outputDir.get().asFile.listFiles().size} reversed files")
	}
}

val target = file("target")

tasks.register<ReverseFiles>("rev") {
	group = "custom"
	description = "reverse files"
	setSource(file("src"))
	outputDir.set(target)
}

tasks.clean {
	delete(target)
}
