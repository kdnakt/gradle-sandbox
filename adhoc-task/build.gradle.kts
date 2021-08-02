tasks.register("processTemplatesAdHoc") {
	inputs.files(fileTree("src/templates"))
		.withPropertyName("sourceFiles")
		.withPathSensitivity(PathSensitivity.RELATIVE)
	inputs.property("templateData.name", "docs")
	inputs.property("templateData.variables",
		mapOf("year" to "2013"))
	outputs.dir(layout.buildDirectory.dir("genOutput2"))
		.withPropertyName("outputDir")
	
	doLast {
		println("processing template adhoc")
	}
}
