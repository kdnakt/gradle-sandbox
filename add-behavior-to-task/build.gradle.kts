tasks.register("hello") {
	doLast {
		println("Hello Earth")
	}
}

tasks.named("hello") {
	doFirst {
		println("Hello Venus")
	}
}

tasks.named("hello") {
	doLast {
		println("Hello Mars")
	}
}

tasks.named("hello") {
	doFirst {
		println("Hello Jupiter")
	}
}
