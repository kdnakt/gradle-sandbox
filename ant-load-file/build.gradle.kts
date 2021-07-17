tasks.register("loadfile") {
	doLast {
		val files = file("./resources").listFiles().sorted()
		files.forEach { file ->
			if (file.isFile) {
				ant.withGroovyBuilder {
					"loadfile"("srcFile" to file, "property" to file.name)
				}
				println(" *** ${file.name} ***")
				println("${ant.properties[file.name]}")
			}
		}
	}
}

tasks.register("checksum") {
	doLast {
		fileList("./resources").forEach { file ->
			ant.withGroovyBuilder {
				"checksum"("file" to file, "property" to "cs_${file.name}")
			}
			println("$file.name checksum: ${ant.properties["cs_${file.name}"]}")
		}
	}
}

fun fileList(dir: String): List<File> =
	file(dir).listFiles { file: File -> file.isFile }.sorted()
