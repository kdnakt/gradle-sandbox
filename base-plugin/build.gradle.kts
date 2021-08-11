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
