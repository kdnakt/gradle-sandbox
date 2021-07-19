tasks.register<Copy>("myCopy")

val myCopy by tasks.existing(Copy::class) {
	from("resources")
	into("target")
}

myCopy {
	include("**/*.txt", "**/*.xml", "**/*.properties")
}

