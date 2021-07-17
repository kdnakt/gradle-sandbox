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
