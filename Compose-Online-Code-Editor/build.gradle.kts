import org.jetbrains.kotlin.config.JVMConfigurationKeys.IR
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.targets.js.KotlinWasmTargetAttribute

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.20" // Make this multiplatform
    id("io.ktor.plugin") version "2.3.9"
    id("org.jetbrains.compose") version "1.5.12"
}

group = "com.tComposeOnlineCodeEditor"
version = "0.0.1"

application {
    mainClass.set("com.ComposeOnlineCodeEditor.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    google()
    jcenter()

}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation ("androidx.compose.ui:ui:1.6.0-alpha03")
    implementation ("androidx.compose.compiler:compiler:1.5.10")
    implementation("androidx.compose.material:material:1.6.3")
    implementation("androidx.compose.ui:ui:1.6.3")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

}
