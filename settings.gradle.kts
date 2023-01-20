@file:Suppress("UnstableApiUsage")

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
    ":features:task-list",
    ":lib-generic:error",
    ":lib-generic:network",
    ":lib-generic:ui",
    ":lib-specific:ui-theme",
)
