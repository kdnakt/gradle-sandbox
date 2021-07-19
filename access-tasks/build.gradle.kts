// access via tasks collection
tasks.register("hello")
tasks.register<Copy>("copy")

println(tasks.named("hello").get().name) // hello

println(tasks.named<Copy>("copy").get().destinationDir) // null

// if the task was added by a plugin
// println(tasks.hello)

// access by type
tasks.withType<Tar>().configureEach {
	enabled = false
}

tasks.register("test") {
	dependsOn(tasks.withType<Copy>())
}

// access by path, not recommended practice
println(tasks.getByPath("hello").path)
println(tasks.getByPath(":hello").path)
println(tasks.getByPath("project-a:hello").path)
println(tasks.getByPath(":project-a:hello").path)

