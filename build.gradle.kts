plugins {
    id("java")
    id("com.gradleup.shadow") version "9.0.0-rc2"
}

group = "com.chumcraft.creativeflatworld"
version = "1.1"
description = "Create a flatworld in four quadrants, one is overworld, one is nether, one is bedrock."
java.sourceCompatibility = JavaVersion.VERSION_21

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
    implementation("org.jetbrains:annotations:23.0.0")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand(project.properties)
        }
    }
    shadowJar {
        archiveBaseName.set("CreativeFlatWorld")
        archiveClassifier.set("")
        archiveVersion.set(project.version.toString())
    }
    build {
        dependsOn(shadowJar)
    }
}


