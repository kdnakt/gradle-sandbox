tasks.register<Copy>("copy") {
	description = "Copies the resource dir to the target dir"
	from("resources")
	into("target")
	include("**/*.txt")
}

tasks.register("taskX") {
	setDescription("This is taskX!")
	doLast {
		println("taskX")
	}
}
