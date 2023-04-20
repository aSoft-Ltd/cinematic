import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile

plugins {
    id("org.jetbrains.compose")
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    signing
}

kotlin {
    if (Targeting.JVM) jvm { library() }

    if (Targeting.JS) js(IR) { library() }

//    if (Targeting.WASM) wasm { library() }

//    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
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
                implementation(projects.kommanderCore)
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

//tasks.withType(KotlinJsCompile::class).configureEach {
//    kotlinOptions {
//        val v = kotlinz.versions.kotlin.get()
//        freeCompilerArgs += listOf(
//            "-P", "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=$v"
//        )
//    }
//}

aSoftOSSLibrary(
    version = asoft.versions.root.get(),
    description = "Bindings for Live<S> object to be used with compose"
)