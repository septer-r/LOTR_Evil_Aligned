import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    id("com.gtnewhorizons.gtnhconvention")
}


val versionProducer = file("version.txt")

fun incrementVersion(): String {
    if (!versionProducer.exists()) {
        versionProducer.writeText("1.0.0")
    }

    val currentVersion = versionProducer.readText().trim()
    val parts = currentVersion.split(".")

    return if (parts.size == 3) {
        val patchVersion = parts[2].toInt() + 1
        val newVersion = "${parts[0]}.${parts[1]}.$patchVersion"
        versionProducer.writeText(newVersion)
        newVersion
    } else {
        "1.0.0"
    }
}


val computedVersion = if (gradle.startParameter.taskNames.contains("build")) {
    val nextVersion = incrementVersion()
    logger.lifecycle("Mode made by SepteR has reached new version! $nextVersion")
    nextVersion
} else {
    if (versionProducer.exists()) versionProducer.readText().trim() else "1.0.0"
}


version = computedVersion


tasks.named<ProcessResources>("processResources") {

    duplicatesStrategy = DuplicatesStrategy.INCLUDE


    notCompatibleWithConfigurationCache("Starsze systemy Forge i filtry tokenów nie są w pełni kompatybilne z cache konfiguracji Gradle 9")

    inputs.property("version", computedVersion)
    inputs.property("mcversion", "1.7.10")


    from(sourceSets.main.get().resources.srcDirs) {
        include("**/*")
    }


    filesMatching("mcmod.info") {
        filter<ReplaceTokens>("tokens" to mapOf(
            "version" to computedVersion,
            "mcversion" to "1.7.10"
        ))
    }
}

tasks.withType<Checkstyle>().configureEach {
    isIgnoreFailures = true
}
configure<CheckstyleExtension> {
    isIgnoreFailures = true
}

dependencies {
    implementation(files("libs/LOTRMod v36.15.jar"))
    implementation(files("libs/schematic4j-1.1.0.jar"))
    runtimeOnly(files("libs/schematic4j-1.1.0.jar"))
    runtimeOnly(files("libs/LOTRMod v36.15.jar"))
    runtimeOnly(files("libs/slf4j-api-1.7.36.jar"))
    implementation(files("libs/slf4j-api-1.7.36.jar"))
}
