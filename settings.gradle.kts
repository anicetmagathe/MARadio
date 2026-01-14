pluginManagement {
    includeBuild("build-logic")

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

rootProject.name = "AndroidProjectTemplate"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":core:common")
include(":core:async")
include(":core:model")
include(":core:domain")
include(":core:data")
include(":core:datastore")
include(":core:datastore-proto")
include(":core:database")
include(":core:designsystem")
include(":core:device:avd")
include(":core:network")
include(":core:ui")
include(":feature:feature1")
 