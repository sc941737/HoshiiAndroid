import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(GradlePlugin.ANDROID_APPLICATION) apply false
    id(GradlePlugin.ANDROID_LIBRARY) apply false
    id(GradlePlugin.KOTLIN_ANDROID) apply false
    id(GradlePlugin.KOTLIN_JVM)
    id(GradlePlugin.SQL_DELIGHT) version Versions.SQL_DELIGHT
}

sqldelight {
    databases {
        create("Tasks") {//todo
            packageName.set("com.hoshii")
        }
    }
}

dependencies {
    implementation(Deps.JetBrains.Kotlin.kotlinStdlib8)
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = Versions.JAVA_VERSION_STR
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = Versions.JAVA_VERSION_STR
}

tasks.clean.configure {
    delete(rootProject.buildDir)
}