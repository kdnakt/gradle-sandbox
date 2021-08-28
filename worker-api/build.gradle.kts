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
		fileSystemOperations.copy {
			from(parameters.fileToReverse)
			into(parameters.destDir)
			filter { line: String -> line.reversed() }
		}
	}
}

abstract class ReverseFiles @Inject constructor(
	private val exec: WorkerExecutor
): SourceTask() {
	@get: OutputDirectory
	abstract val outputDir: DirectoryProperty

	@TaskAction
	fun reverseFiles() {
		val queue = exec.noIsolation()

		source.forEach { file ->
			queue.submit(ReverseFile::class) {
				fileToReverse.set(file)
				destDir.set(outputDir)
			}
		}
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
