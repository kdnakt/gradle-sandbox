val taskX by tasks.registering {
	doLast {
		println("taskX")
	}
}

val taskY by tasks.registering {
	doLast {
		println("taskY")
	}
}

taskY {
	mustRunAfter(taskX)
}

val taskZ by tasks.registering {
	doLast {
		println("taskZ")
	}
}

taskZ {
	shouldRunAfter(taskX)
}

