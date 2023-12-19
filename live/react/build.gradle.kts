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
                api(projects.cinematicLiveCore)
                api(project.dependencies.platform(kotlinw.bom))
                api(kotlinw.react.core)
            }
        }
    }
}