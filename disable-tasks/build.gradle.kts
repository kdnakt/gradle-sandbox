val disableMe by tasks.registering {
	doLast {
		println("This should not be printed")
	}
}

disableMe {
	enabled = false
}
