plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

description = "Tools for testing Live<S> objects"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() }
//    if (Targeting.WASM) wasm { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.kommanderCore)
                api(projects.cinematicLiveCore)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(projects.kommanderCoroutines)
            }
        }
    }
}