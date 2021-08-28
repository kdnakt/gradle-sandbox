tasks.register<Copy>("copy") {
	group = "Copy"
	description = "Copies the resource dir to the target dir"
	from("resources")
	into("target")
	include("**/*.txt")
}

tasks.register("taskX") {
	setGroup("Custom")
	setDescription("This is taskX!")
	doLast {
		println("taskX")
	}
}
