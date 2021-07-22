abstract class CustomTask @Inject constructor(
	private val message: String,
	private val number: Int
): DefaultTask() {
	@TaskAction
	fun doSomething() {
		println("$message: $number")
	}
}

tasks.register<CustomTask>("myTask", "hello", 42)

