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
}
