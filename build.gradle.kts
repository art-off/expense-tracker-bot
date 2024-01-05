import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
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

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    archiveFileName.set("expense-tracker-bot.jar")
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(17)
}
