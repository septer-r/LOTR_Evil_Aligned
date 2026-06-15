val versionProducer = file("version.txt")

fun incrementVersion(): String {
    if (!versionProducer.exists()) {
        versionProducer.writeText("1.0.0");
    }


    val currentVersion = versionProducer.readText().trim();
    val parts = currentVersion.split(".");

    return if (parts.size == 3){

        val patchVersion = parts[2].toInt() +1;
        val newVersion = "${parts[0]}.${parts[1]}.$patchVersion";

        versionProducer.writeText(newVersion);
        newVersion;


    } else{
        return "1.0.0";
    }


}

if(gradle.startParameter.taskNames.contains("build")){
    val nextVersion = incrementVersion();
    version = nextVersion;
    logger.lifecycle("Mode made by SepteR has reached new version! $nextVersion")
} else{
    version = if(versionProducer.exists()) versionProducer.readText().trim() else "1.0.0";
}


plugins {
    id("com.gtnewhorizons.gtnhconvention")
}
dependencies{
    implementation(files("libs/LOTRMod v36.15.jar"))

    runtimeOnly(files("libs/LOTRMod v36.15.jar"))
}
