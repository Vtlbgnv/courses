pluginManagement {
	repositories {
		google {
			content {
				includeGroupByRegex("com\\.android.*")
				includeGroupByRegex("com\\.google.*")
				includeGroupByRegex("androidx.*")
			}
		}
		mavenCentral()
		gradlePluginPortal()
	}
}

dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
	}
}

rootProject.name = "courses"
include(":app")
include(":core:navigation")
include(":core:network")
include(":features:mainhost")
include(":features:profile")
include(":features:userfavorites")
include(":features:main:courses")
include(":features:main:details")
include(":shared:favorites")
include(":components:ui")
include(":components:presentation")
