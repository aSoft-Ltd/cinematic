plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

description = "A multiplatfrom library for authoring Scenes (viewmodel) in an MVIVM architecture"

configureAndroid("src/androidMain") {
    defaultConfig {
        minSdk = 14
    }
}

kotlin {
    android { library() }
    jvm { library() }
    if (Targeting.JS) js(IR) { library() }
//    if (Targeting.WASM) wasm { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
//    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()

    val nativeTargets = osxTargets + linuxTargets // + mingwTargets
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.cinematicLiveCore)
                api(kotlinx.serialization.json)
                api(projects.keepApi)
                api(projects.keepMock)
                api(projects.lexiConsole)
                api(projects.krestCore)
                api(projects.kaseCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(projects.kommanderCoroutines)
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

        for (target in nativeTargets) {
            val main by target.compilations.getting {
                defaultSourceSet {
                    dependsOn(nonAndroidMain)
                }
            }
        }
    }
}