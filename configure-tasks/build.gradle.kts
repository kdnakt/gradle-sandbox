tasks.register<Copy>("myCopy")

tasks.named<Copy>("myCopy") {
	from("resources")
	into("target")
	include("**/*.txt", "**/*.xml", "**/*.properties")
}


