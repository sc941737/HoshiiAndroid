plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.KSP) version Versions.KSP
}

android {
    configureAndroidLib("ui")
}

dependencies {
    api(Deps.AndroidX.Activity.activityKtx)
    api(Deps.AndroidX.Lifecycle.lifecycleViewmodelKtx)
    api(Deps.JetBrains.KotlinX.Coroutines.kotlinxCoroutinesCore)
    api(Deps.JetBrains.KotlinX.Coroutines.kotlinxCoroutinesAndroid)
}