@file:Suppress("UnstableApiUsage")

include(":lib-specific:local-db")


pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "HoshiiAndroid"
include(
    ":app",
    ":features:entry-list",
    ":lib-generic:error",
    ":lib-generic:network",
    ":lib-generic:ui",
    ":lib-specific:ui-theme",
)
