project("project-a") {
	tasks.register("taskX") {
		dependsOn(":project-b:taskY")
		doLast {
			println("taskX")
		}
	}
}

project("project-b") {
	tasks.register("taskY") {
		doLast {
			println("taskY")
		}
	}
}

