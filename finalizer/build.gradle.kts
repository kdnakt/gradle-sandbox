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

taskX {
	finalizedBy(taskY)
}

val taskA by tasks.registering {
	doLast {
		println("taskA")
		throw RuntimeException()
	}
}

val taskB by tasks.registering {
	doLast {
		println("taskB")
	}
}

taskA {
	finalizedBy(taskB)
}
