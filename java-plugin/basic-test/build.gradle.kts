plugins {
	java
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation("junit:junit:4.13")
}

tasks.test {
	// default is JUnit 4, no need to call explicitly
	// useJUnit()

	maxHeapSize = "1G"

	// events in the test execution lifecycle
	addTestListener(object: TestListener {
		override fun beforeSuite(d: TestDescriptor) {}
		override fun beforeTest(descriptor: TestDescriptor) {
			logger.lifecycle("Running test: $descriptor")
		}
		override fun afterTest(d: TestDescriptor, r: TestResult) {}
		override fun afterSuite(d: TestDescriptor, r: TestResult) {}
	})
}
