plugins {
	base
}

repeat(5) { counter ->
	project("p$counter") {
		tasks.register("task$counter") {
			doLast {
				Thread.sleep(1000L * counter)
				println("I'm task number $counter")
			}
		}
	}
}


tasks.build {
	dependsOn(":p0:task0")
	dependsOn(":p1:task1")
	dependsOn(":p2:task2")
	dependsOn(":p3:task3")
	dependsOn(":p4:task4")
}
