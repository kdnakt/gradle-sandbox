tasks.register("removeTempDir") {
	destroyables.register(layout.projectDirectory.dir("tmpDir"))
	doLast {
		delete(layout.projectDirectory.dir("tmpDir"))
	}
}
