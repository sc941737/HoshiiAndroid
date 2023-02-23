plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.KOTLIN_SERIALIZATION) version Versions.KOTLIN
    id(GradlePlugin.SQL_DELIGHT) version Versions.SQL_DELIGHT
}

android {
    configureAndroidLib("local_db")
}

dependencies {
    api(Deps.JetBrains.KotlinX.Serialization.serializationJson) // Serializable
    implementation(Deps.SQLDelight.driver)
    implementation(Deps.SQLDelight.primitiveAdapters)
    implementation(Deps.SQLDelight.coroutinesExt)
}