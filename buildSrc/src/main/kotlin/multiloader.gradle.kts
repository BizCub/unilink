plugins {
    id("multiloader-common")
    id("me.modmuss50.mod-publish-plugin")
}

sc.replacements {
    string(scp >= "1.21.11" && !isForge, "auto_config") {
        replace("AutoConfig", "AutoConfigClient")
    }
}

if (isForge) {
    if (!isClothConfigAvailable) {
        setProp("cloth_config", "17.0.144")
    }
}

reps.clear()
reps.add(Repository("https://maven.shedaniel.me"))

deps.clear()
deps.add(Dependency("me.shedaniel.cloth:cloth-config-${mod.loader}:${getProp("cloth_config")}", "implementation"))

if (isFabric) {
    reps.add(Repository("https://maven.terraformersmc.com/releases"))

    deps.add(Dependency("net.fabricmc:fabric-loader:latest.release", "implementation"))
    deps.add(Dependency("com.terraformersmc:modmenu:${getProp("modmenu")}", "api"))
}

if (isNeoForge) {
    reps.add(Repository("https://maven.neoforged.net/releases"))
}

publishMods {
    modrinth {
        if (isClothConfigAvailable) requires("cloth-config")
        if (isFabric) optional("modmenu")
    }
    curseforge {
        if (isClothConfigAvailable) requires("cloth-config")
        if (isFabric) optional("modmenu")
    }
}
