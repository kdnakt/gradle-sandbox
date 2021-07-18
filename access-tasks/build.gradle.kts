tasks.register("hello")
tasks.register<Copy>("copy")

println(tasks.named("hello").get().name) // hello

println(tasks.named<Copy>("copy").get().destinationDir) // null

// if the task was added by a plugin
// println(tasks.hello)
