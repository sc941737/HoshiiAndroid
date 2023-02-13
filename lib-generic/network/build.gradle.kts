plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.KOTLIN_SERIALIZATION) version Versions.KOTLIN
}

android {
    configureAndroidLib("network")
}

dependencies {
    api(Deps.Ktor.ktorClientAndroid)
    api(Deps.Ktor.ktorClientCore)
    api(Deps.Ktor.ktorClientContentNegotiation)
    api(Deps.Ktor.ktorClientResources)
    api(Deps.Ktor.ktorClientSerializationJson)
    api(Deps.JetBrains.KotlinX.Serialization.serializationJson) // Serializable
    implementation(Deps.Ktor.ktorClientLogging)
}