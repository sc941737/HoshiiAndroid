import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
    mavenCentral()
    google()
}

plugins {
    `kotlin-dsl`
}

sourceSets["main"].java.srcDir("src/main/kotlin")

dependencies {
    implementation("com.android.tools.build:gradle:7.4.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation(gradleApi())
    implementation(localGroovy())
}