plugins {
    id("java")
}

group = "com.chumcraft.creativeflatworld"
version = "1.1"
description = "Create a flatworld in four quadrants, one is overworld, one is nether, one is bedrock."
java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:23.0.0")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}