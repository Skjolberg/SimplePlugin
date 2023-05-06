plugins {
    java
    id("com.github.johnrengelman.shadow") version ("7.1.2")
}

val libs = "net.shibacraft.simpleplugin.api.libs"

group = "net.shibacraft"
version = "0.0.9-SNAPSHOT"

/*configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}*/

repositories {
    //mavenLocal()
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.unnamed.team/repository/unnamed-public/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://jitpack.io")
    maven("https://repo.alessiodp.com/releases/")
}

dependencies {
    implementation("net.md-5:specialsource-maven-plugin:1.2.4")
    compileOnly("com.google.inject:guice:5.1.0")
    implementation("com.github.Skjolberg:SimpleApi:0.0.13")

    //compileOnly("com.google.inject:guice:5.0.1")
    implementation("net.byteflux:libby-bukkit:1.1.5")
    implementation("me.fixeddev:commandflow-bukkit:0.5.2")

    compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

tasks {
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
    }
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    shadowJar {
        delete(file("${project.buildDir}"))
        archiveClassifier.set("")
        archiveFileName.set("${project.name}-${project.version}.jar")
        //relocate("me.fixeddev.commandflow", "$libs.cmdFlow")
        //relocate("net.kyori.text", "$libs.kyori")
        //relocate("org.bstats", "$libs.bStats")
        //relocate("de.leonhard.storage", "$libs.leonhardStorage")
        //relocate("org.checkerframework", "$libs.jetbrains")
        //relocate("org.jetbrains.annotations", "$libs.jetbrains")
        minimize()
    }
    build {
        dependsOn(shadowJar)
    }
    processResources {
        filesMatching("plugin.yml") {
            expand("v" to project.version)
        }
    }

}