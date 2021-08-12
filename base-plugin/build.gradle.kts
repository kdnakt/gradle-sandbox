plugins {
	base
}

val taskX by tasks.registering {
	doLast {
		println("taskX")
	}
}

tasks.check {
	dependsOn(taskX)
}

val taskY by tasks.registering {
	doLast {
		println("taskY")
	}
}

tasks.assemble {
	dependsOn(taskY)
}

val taskZ by tasks.registering {
	doLast {
		println("taskZ")
	}
}

tasks.build {
	dependsOn(taskZ)
}

base {
	archivesName.set("gradle")
	distsDirectory.set(layout.buildDirectory.dir("custom-dist"))
	libsDirectory.set(layout.buildDirectory.dir("custom-libs"))
}
