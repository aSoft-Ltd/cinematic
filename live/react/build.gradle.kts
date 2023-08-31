plugins {
    kotlin("js")
    id("tz.co.asoft.library")
}

description = "An extension of the Live<T> targeted for react"

kotlin {
    js(IR) { browserLib() }
    sourceSets {
        val main by getting {
            dependencies {
                api(libs.cinematic.live.core)
                api(project.dependencies.platform(kotlinw.bom))
                api(kotlinw.react.core)
            }
        }
    }
}