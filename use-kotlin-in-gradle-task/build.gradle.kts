tasks.register("upper") {
	doLast {
		val someString = "mY_nAmE"
		println("original: $someString")
		println("upper case: ${someString.toUpperCase()}")
	}
}

tasks.register("count") {
	doLast {
		repeat(4) { print("$it ") }
	}
}
