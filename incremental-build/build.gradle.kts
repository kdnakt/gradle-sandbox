import org.example.ProcessTemplates

tasks.register<ProcessTemplates>("processTemplates") {
	templateData.name.set("myTemplate")
	outputDir.set(file("target"))
}
