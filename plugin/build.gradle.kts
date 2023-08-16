plugins {
	`java-gradle-plugin`
	groovy

	id("org.jetbrains.kotlin.jvm")
	id("com.gradle.plugin-publish")
}

kotlin {
	jvmToolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

dependencies {
	compileOnly(group = "pl.allegro.tech.build", name = "axion-release-plugin", version = "1.15.4")

	// Use the Kotlin JUnit 5 integration.
	testImplementation(group = "org.jetbrains.kotlin", name = "kotlin-test-junit5")

	testImplementation(group = "org.spockframework", name = "spock-core", version = "2.3-groovy-3.0")
	testImplementation(group = "org.reflections", name = "reflections", version = "0.10.2")
}

@Suppress("UnstableApiUsage")
gradlePlugin {
	website.set("https://discuss.gradle.org/t/add-configuration-when-plugin-is-applied-handling-different-plugin-versions/46270/")
	vcsUrl.set("ssh://git@github.com:maxnitze/gradle-plugin-46270-mcve.git")

	plugins {
		create("myProjectPlugin") {
			id = "com.example.gradle.my-project-plugin"
			displayName = "My Project Plugin"
			description = "TBD"
			tags.set(listOf("gradle", "project"))
			implementationClass = "com.example.gradle.plugins.project.MyProjectPlugin"
		}
	}
}
