import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

description = "A multiplatfrom library for authoring Scenes (viewmodel) in an MVIVM architecture"

configureAndroid("src/androidMain") {
    namespace = "tz.co.asoft.cinematic.scene.core"
    defaultConfig {
        minSdk = 14
    }

    lintOptions {
        isAbortOnError = false
    }
}

kotlin {
    androidTarget { library() }
    jvm { library() }
    if (Targeting.JS) js(IR) { library() }
    if (Targeting.WASM) wasmJs { library() }
    if (Targeting.WASM) wasmWasi { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
//    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()

    val nativeTargets = osxTargets + linuxTargets // + mingwTargets
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.cinematicLiveCore)
                api(libs.kase.core)
            }
        }

        val androidMain by getting {
            dependencies {
                api(androidx.lifecycle.viewmodel.ktx)
            }
        }

        val nonAndroidMain by creating {
            dependsOn(commonMain)
        }

        val jvmMain by getting {
            dependsOn(nonAndroidMain)
        }

        if (Targeting.JS) {
            val jsMain by getting {
                dependsOn(nonAndroidMain)
            }
        }

        if (Targeting.WASM) {
            val wasmJsMain by getting {
                dependsOn(nonAndroidMain)
            }

            val wasmWasiMain  by getting {
                dependsOn(nonAndroidMain)
            }
        }

        for (target in nativeTargets) {
            val main by target.compilations.getting {
                defaultSourceSet {
                    dependsOn(nonAndroidMain)
                }
            }
        }
    }
}
