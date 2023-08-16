package com.example.gradle.plugins.project

import org.gradle.api.Plugin
import org.gradle.api.Project
import pl.allegro.tech.build.axion.release.domain.VersionConfig

class MyProjectPlugin : Plugin<Project> {

	override fun apply(project: Project) {
		project.pluginManager.withPlugin("pl.allegro.tech.build.axion-release") {
			val versionConfig = project.extensions.getByType(VersionConfig::class.java)
			versionConfig.apply {
				versionIncrementer("branchSpecific", mapOf(
					"^(main|master|HEAD)$" to "incrementMinor",
					".*" to "incrementPatch"
				))

				snapshotCreator { _, position ->
					if (position.branch in setOf("main", "master", "HEAD") || position.branch.matches(Regex("^release\\/\\d+(.x|(\\.\\d+)+)$"))) {
						"-${position.shortRevision}-SNAPSHOT"
					} else {
						"-${position.branch.take(15)}-${position.shortRevision}-SNAPSHOT"
					}
				}
			}

			project.version = versionConfig.version
		}
	}
}
