val hello by tasks.registering {
	doLast {
		println("hello")
	}
}

val copy by tasks.registering(Copy::class) {
	from(file("srcDir"))
	into(buildDir)
}

tasks.register<Copy>("copy2") {
	from(file("srcDir2"))
	into(buildDir)
}
