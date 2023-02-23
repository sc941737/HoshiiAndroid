@file:Suppress("UnstableApiUsage")

plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.KSP) version Versions.KSP
}

android {
    configureAndroidFeature("entry_list")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "entry_list")
}

dependencies {
    implementation(project(Modules.Lib.Specific.localDb))
    api(Deps.AndroidX.Activity.activityKtx)
    api(Deps.JetBrains.KotlinX.Coroutines.kotlinxCoroutinesCore)
    implementation(Deps.AndroidX.Lifecycle.lifecycleProcess)
    implementation(Deps.AndroidX.Activity.activityCompose)
}