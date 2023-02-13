import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

object AndroidConfig {
    const val COMPILE_SDK_VERSION = 33
    const val MIN_SDK_VERSION = 26
    const val TARGET_SDK_VERSION = 33
    const val BUILD_TOOLS_VERSION = "33.0.0"
}

fun Project.configureAndroidFeature(featureName: String) = this.extensions.getByType(
    LibraryExtension::class.java
).run {
    namespace = "com.hoshii.features.$featureName"
    configureDefaultConfig()
    configureCompose(withDestinations = true)
    dependencies {
        configureFeatureDeps()
    }
}

private fun DependencyHandler.configureFeatureDeps() {
    // Modules
    implementation(project(Modules.Lib.Generic.error))
    implementation(project(Modules.Lib.Generic.ui))
    implementation(project(Modules.Lib.Specific.uiTheme))

    // Navigation
    implementation(Deps.Raamcosta.ComposeDestinations.core)
    add("ksp", Deps.Raamcosta.ComposeDestinations.ksp)

    // Android
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.Lifecycle.lifecycleRuntimeKtx)
    implementation(Deps.AndroidX.Lifecycle.lifecycleViewmodelKtx)

    // Kotlin
    implementation(Deps.JetBrains.KotlinX.Coroutines.kotlinxCoroutinesAndroid)

    // Dependcy injection
    implementation(Deps.Koin.android)
    implementation(Deps.Koin.androidCompose)

    // Test
    testImplementation(Deps.Test.JUnit.junit4)
    androidTestImplementation(Deps.Test.Android.Espresso.espressoCore)
    androidTestImplementation(Deps.Test.Android.Ext.junitKtx)
    androidTestImplementation(Deps.AndroidX.Compose.Ui.uiTestJunit4)
}

fun Project.configureAndroidLib(libName: String) = this.extensions.getByType(
    LibraryExtension::class.java
).run {
    namespace = "com.hoshii.lib.$libName"
    configureDefaultConfig()
    dependencies {
        configureLibDeps()
    }
}

private fun DependencyHandler.configureLibDeps() {
    // Android
    api(Deps.AndroidX.coreKtx)

    // Kotlin
    api(Deps.JetBrains.Kotlin.kotlinStdlib)

    // Dependency injection
    implementation(Deps.Koin.android)

    // Test
    testImplementation(Deps.Test.JUnit.junit4)
    androidTestImplementation(Deps.Test.Android.Espresso.espressoCore)
    androidTestImplementation(Deps.Test.Android.Ext.junitKtx)
}

fun Project.configureDefaultConfig() = this.extensions.getByType(
    LibraryExtension::class.java
).run {
    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK_VERSION
        compileSdk = AndroidConfig.COMPILE_SDK_VERSION
    }
}

fun Project.configureCompose(withDestinations: Boolean = false) = this.extensions.getByType(
    LibraryExtension::class.java
).run {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.AndroidX.Compose.Compiler.compilerVersion
    }
    if (withDestinations) {
        configureComposeDestinations()
    }
}

fun Project.configureComposeDestinations() = this.extensions.getByType(
    LibraryExtension::class.java
).run {
    libraryVariants.all {
        kotlinExtension.sourceSets.apply {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

private fun DependencyHandler.implementation(dependency: Any) =
    add("implementation", dependency)

private fun DependencyHandler.testImplementation(dependency: Any) =
    add("testImplementation", dependency)

private fun DependencyHandler.androidTestImplementation(dependency: Any) =
    add("androidTestImplementation", dependency)

private fun DependencyHandler.api(dependency: Any) =
    add("api", dependency)
