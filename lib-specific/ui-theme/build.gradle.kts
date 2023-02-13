@file:Suppress("UnstableApiUsage")

plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KOTLIN_ANDROID)
}

android {
    configureAndroidLib("ui_theme")
    configureCompose()
}

dependencies {
    api(Deps.AndroidX.Compose.Material.material)
    api(Deps.AndroidX.Compose.Material.materialIconsCore)
    api(Deps.AndroidX.Compose.Material.materialIconsExtended)
    api(Deps.AndroidX.Compose.Ui.ui)
    api(Deps.AndroidX.Compose.Ui.uiTooling)
    api(Deps.AndroidX.Compose.Ui.uiToolingPreview)
    implementation(Deps.JetBrains.KotlinX.Coroutines.kotlinxCoroutinesCore)
}