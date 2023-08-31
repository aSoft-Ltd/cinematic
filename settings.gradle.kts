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

listOf(
	"kommander", "kollections", "kevlar", "kase", "koncurrent"
).forEach {
	includeBuild("../$it")
}

rootProject.name = "cinematic"

// submodules
includeSubs("cinematic-live", "live", "core", "coroutines", "compose", "react", "test", "kollections")
includeSubs("cinematic-scene", "scene", "core")
