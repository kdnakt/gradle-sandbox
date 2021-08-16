plugins {
	java
}

java {
	toolchain {
		// エラー: 文字列リテラルが閉じられていません
		languageVersion.set(JavaLanguageVersion.of(11))
	}
}

tasks.forEach { println(it) }
/**
task ':assemble'
task ':build'
task ':buildDependents'
task ':buildEnvironment'
task ':buildNeeded'
task ':check'
task ':classes'
task ':clean'
task ':compileJava'
task ':compileTestJava'
task ':components'
task ':dependencies'
task ':dependencyInsight'
task ':dependentComponents'
task ':help'
task ':init'
task ':jar'
task ':javaToolchains'
task ':javadoc'
task ':kotlinDslAccessorsReport'
task ':model'
task ':outgoingVariants'
task ':prepareKotlinBuildScriptModel'
task ':processResources'
task ':processTestResources'
task ':projects'
task ':properties'
task ':tasks'
task ':test'
task ':testClasses'
task ':wrapper'
*/
