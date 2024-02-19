import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("tz.co.asoft.library")
}

description = "Bindings for Live<S> object to be used with compose"

kotlin {
    if (Targeting.JVM) jvm { library(jupiter = false) }
    if (Targeting.JS) js(IR) { library() }
    if (Targeting.WASM) wasmJs { library() }

    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
//    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
//    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.cinematicLiveCore)
                api(compose.runtime)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kommander.core)
            }
        }

        val jvmTest by getting {
            @OptIn(ExperimentalComposeLibrary::class)
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(compose.uiTestJUnit4)
            }
        }
    }
}

compose {
    kotlinCompilerPlugin.set(kotlinz.versions.compose.compiler)
    kotlinCompilerPluginArgs.add(kotlinz.versions.kotlin.map {
        "suppressKotlinVersionCompatibilityCheck=$it"
    })
}

rootProject.the<NodeJsRootExtension>().apply {
    version = npm.versions.node.version.get()
    downloadBaseUrl = npm.versions.node.url.get()
}

rootProject.tasks.withType<KotlinNpmInstallTask>().configureEach {
    args.add("--ignore-engines")
}

tasks.named("wasmJsTestTestDevelopmentExecutableCompileSync").configure {
    mustRunAfter(tasks.named("jsBrowserTest"))
}