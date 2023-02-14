@file:Suppress("unused")

object Deps {

    object AndroidX {
        // Versions: https://developer.android.com/jetpack/androidx/versions
        const val coreKtx = "androidx.core:core-ktx:1.9.0"

        object Activity {
            // Versions: https://developer.android.com/jetpack/androidx/releases/activity
            private const val version = "1.6.1"
            const val activity = "androidx.activity:activity:$version"
            const val activityKtx = "androidx.activity:activity-ktx:$version"
            const val activityCompose = "androidx.activity:activity-compose:$version"
        }

        object Compose {
            // Versions: https://developer.android.google.cn/jetpack/androidx/releases/compose?hl=en#versions
            private const val version = "1.3.1"

            object Animation {
                private const val animationVersion = "1.3.3"
                const val animation = "androidx.compose.animation:animation:$animationVersion"
            }
            object Compiler {
                const val compilerVersion = "1.4.2"
                const val compiler = "androidx.compose.compiler:compiler:$compilerVersion"
                // NOTE: Compose Compiler's version can be set explicitly
                //       with android.composeOptions.kotlinCompilerExtensionVersion.
            }
            object Foundation {
                const val foundation = "androidx.compose.foundation:foundation:$version"
            }
            object Material {
                const val material = "androidx.compose.material:material:$version"
                const val materialIconsCore = "androidx.compose.material:material-icons-core:$version"
                const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            }
            object Material3 {
                private const val version = "1.0.1"
                const val material3 = "androidx.compose.material3:material3:$version"
            }
            object Ui {
                private const val uiVersion = "1.3.3"
                const val ui = "androidx.compose.ui:ui:$uiVersion"
                // Tooling support (Previews, etc.)
                const val uiTooling = "androidx.compose.ui:ui-tooling:$uiVersion"
                const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$uiVersion"
                const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:$uiVersion"
                const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$uiVersion"
            }
        }

        object Lifecycle {
            // Versions: https://developer.android.com/jetpack/androidx/releases/lifecycle
            private const val version = "2.5.1"
            const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:$version"
            // Process
            const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:$version"
            // ViewModel
            const val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val lifecycleViewmodelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        }

        object Security {
            // Versions: https://developer.android.com/jetpack/androidx/releases/security
            private const val version = "1.1.0-alpha04"
            const val securityCrypto = "androidx.security:security-crypto:$version"
            const val securityIdentityCredential = "androidx.security:security-identity-credential:$version"
        }
    }

    object Auth0 {
        // Versions: https://github.com/auth0/JWTDecode.Android/releases
        const val jwtDecode = "com.auth0.android:jwtdecode:2.0.2"
    }

    object JakeWharton {
        // Versions: https://github.com/JakeWharton/timber/releases
        const val timber = "com.jakewharton.timber:timber:5.0.1"
    }

    object JetBrains {
        object Kotlin {
            // Changelog: https://kotlinlang.org/docs/releases.html#release-details
            // Versions: https://github.com/JetBrains/kotlin/releases
            const val version = Versions.KOTLIN
            const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
            const val kotlinStdlib8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
            const val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:$version"
            const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        }

        object KotlinX {
            object Collections {
                // Versions: https://github.com/Kotlin/kotlinx.collections.immutable/releases
                private const val version = "0.3.5"
                const val kotlinxCollectionsImmutable = "org.jetbrains.kotlinx:kotlinx-collections-immutable:$version"
                const val kotlinxCollectionsImmutableJvm =
                    "org.jetbrains.kotlinx:kotlinx-collections-immutable-jvm:$version"
            }

            object Coroutines {
                // Versions: https://github.com/Kotlin/kotlinx.coroutines/releases
                private const val version = "1.6.4"
                const val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
                const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            }

            object Serialization {
                // Versions: https://github.com/Kotlin/kotlinx.serialization/releases
                const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"
                const val classPath = "org.jetbrains.kotlinx:kotlinx-serialization:1.5.21"
            }
        }
    }

    object Koin {
        // Versions: https://insert-koin.io/docs/setup/koin
        private const val version = "3.3.3"
        private const val composeVersion = "3.4.2"
        const val android = "io.insert-koin:koin-android:$version"
        const val androidCompose = "io.insert-koin:koin-androidx-compose:$composeVersion"
        const val junit4 = "io.insert-koin:koin-test-junit4:$version"
    }

    object Ktor {
        // Versions: https://github.com/ktorio/ktor/releases
        private const val version = "2.2.2"
        const val ktorClientAndroid = "io.ktor:ktor-client-android:$version"
        const val ktorClientCore = "io.ktor:ktor-client-core:$version"
        const val ktorClientContentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val ktorClientLogging = "io.ktor:ktor-client-logging:$version"
        const val ktorClientResources = "io.ktor:ktor-client-resources:$version"
        const val ktorClientSerialization = "io.ktor:ktor-client-serialization:$version"
        const val ktorClientSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:$version"
    }

    object OpenId {
        // Versions: https://search.maven.org/search?q=g:net.openid%20appauth
        const val appAuth = "net.openid:appauth:0.11.1"
    }

    object Raamcosta {
        object ComposeDestinations {
            // Versions: https://github.com/raamcosta/compose-destinations/releases
            const val version = "1.7.33-beta" // Depends on Compose version
            const val core = "io.github.raamcosta.compose-destinations:core:$version"
            const val ksp = "io.github.raamcosta.compose-destinations:ksp:$version"
        }
    }

    object SQLDelight {
        // Versions: https://github.com/cashapp/sqldelight/releases
        const val version = "2.0.0-alpha05"
        const val driver = "app.cash.sqldelight:android-driver:$version"
        const val primitiveAdapters = "app.cash.sqldelight:primitive-adapters:$version"
        const val coroutinesExt = "app.cash.sqldelight:coroutines-extensions:$version"
    }

    object Test {
        object Android {
            // Versions: https://developer.android.com/jetpack/androidx/releases/test
            private const val version = "1.5.0"

            // Core library
            const val core = "androidx.test:core:$version"

            object Espresso {
                private const val espressoVersion = "3.5.1"
                const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
            }

            object Ext {
                private const val junitVersion = "1.1.5"
                const val junitKtx = "androidx.test.ext:junit-ktx:$junitVersion"
                private const val truthVersion = "1.5.0"
                const val truth = "androidx.test.ext:truth:$truthVersion"
            }
        }

        object JUnit {
            // Versions: https://github.com/junit-team/junit4/releases
            const val junit4 = "junit:junit:4.13.2"
        }
    }
}