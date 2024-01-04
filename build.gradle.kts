plugins {
    val kotlinVersion = "1.8.21"
    kotlin("jvm") version kotlinVersion
    application
}

group = "ru.art-off"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.inmo:tgbotapi:9.4.3")
    implementation("ch.qos.logback:logback-classic:1.2.6")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(19)
}