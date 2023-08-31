@Suppress("DSL_SCOPE_VIOLATION") plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    signing
}

description = "Extensions for Live<S> object to be used with compose"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() }
//    if (Targeting.WASM) wasm { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf ()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.cinematic.live.core)
                api(libs.kollections.interoperable)
            }
        }

        val commonTest by getting {
            dependencies {
                api(libs.cinematic.live.test)
            }
        }
    }
}