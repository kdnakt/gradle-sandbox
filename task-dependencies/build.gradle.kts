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

