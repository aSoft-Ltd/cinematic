pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}


includeBuild("../koncurrent")

rootProject.name = "cinematic"

// submodules
includeSubs("cinematic-live", "live", "core", "coroutines", "compose", "react", "test", "kollections")
includeSubs("cinematic-scene", "scene", "core")
