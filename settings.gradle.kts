pluginManagement {
	plugins {
		id("com.gradle.plugin-publish") version "1.2.0"
		id("org.jetbrains.kotlin.jvm") version "1.7.10"
	}

	repositories {
		mavenLocal()
		gradlePluginPortal()
	}
}

dependencyResolutionManagement {
	repositories {
		mavenLocal()
		mavenCentral()
	}
}

rootProject.name = "mcve-46270"
include("plugin")
include("usage")
