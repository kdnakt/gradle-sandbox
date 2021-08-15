plugins {
	java
}

sourceSets {
	main {
		java {
			setSrcDirs(listOf("src/java"))
		}
		resources {
			setSrcDirs(listOf("src/resources"))
		}
	}
}

