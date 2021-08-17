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
	useJUnit()

	maxHeapSize = "1G"
}
