plugins {
	java
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("log4j:log4j:1.2.17")
}

tasks.register("printArtifactNames") {
	// always executed
	// val libraryNames = configurations.compileClasspath.get().map { it.name }

	doLast {
		// logic during execution phase is preferred
		val libraryNames = configurations.compileClasspath.get().map { it.name }
		logger.quiet(libraryNames.toString())
	}
}
