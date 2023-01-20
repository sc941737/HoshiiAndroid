@file:Suppress("UnstableApiUsage")

plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.KSP) version Versions.KSP
}

android {
    namespace = "com.hoshii.features.task_list"

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK_VERSION
        compileSdk = AndroidConfig.COMPILE_SDK_VERSION
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.AndroidX.Compose.version
    }
    libraryVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

dependencies {
    implementation(project(":lib-generic:error"))
    implementation(project(":lib-generic:ui"))
    implementation(project(":lib-specific:ui-theme"))
    api(Deps.AndroidX.Activity.activityKtx)
    api(Deps.AndroidX.Lifecycle.lifecycleViewmodelKtx)
    api(Deps.JetBrains.KotlinX.Coroutines.kotlinxCoroutinesCore)
    api(Deps.JetBrains.KotlinX.Coroutines.kotlinxCoroutinesAndroid)
    implementation(Deps.Koin.android)
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.Lifecycle.lifecycleProcess)
    implementation(Deps.AndroidX.Lifecycle.lifecycleRuntime)
    implementation(Deps.AndroidX.Activity.activityCompose)
    implementation(Deps.Koin.android)
    implementation(Deps.Koin.androidCompose)
    implementation(Deps.Raamcosta.ComposeDestinations.core)
    ksp(Deps.Raamcosta.ComposeDestinations.ksp)
}