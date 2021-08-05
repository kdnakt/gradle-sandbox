tasks.addRule("Pattern: ping<ID>") {
	val taskName = this
	if (startsWith("ping")) {
		task(taskName) {
			doLast {
				println("Pinging: " + (taskName.replace("ping", "")))
			}
		}
	}
}
