plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

description = "An multiplatform representation of a Live<T> object"

kotlin {
    if (Targeting.JVM) jvm { withJava(); library() }
    if (Targeting.JS) js(IR) { library() } //
    if (Targeting.WASM) wasmJs { library() }
    if (Targeting.WASM) wasmWasi { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()

    val nativeTargets = osxTargets + /*ndkTargets +*/ linuxTargets + mingwTargets

    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.exports)
        }
        commonTest.dependencies {
            implementation(libs.kommander.core)
            implementation(libs.koncurrent.executors.mock)
        }

        if (Targeting.JVM) jvmTest.dependencies {
            implementation(kotlin("test-junit5"))
        }
    }
}
