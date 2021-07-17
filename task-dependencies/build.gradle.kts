tasks.register("hello") {
	doLast {
		println("Hello World!")
	}
}

tasks.register("intro") {
	dependsOn("hello")
	doLast {
		println("I'm Gradle")
	}
}

tasks.register("taskX") {
	dependsOn("taskY")
	doLast {
		println("taskX")
	}
}

tasks.register("taskY") {
	doLast {
		println("taskY")
	}
}

