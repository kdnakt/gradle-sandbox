tasks.register("processTemplatesAdHocSkipWhenEmpty") {
	inputs.files(fileTree("src/templates") {
		include("**/*.fm")
	})
	.skipWhenEmpty()
	.withPropertyName("sourceFiles")
	.withPathSensitivity(PathSensitivity.RELATIVE)
	
	doLast {
		println("process ad hoc, skip when empty")
	}
}
