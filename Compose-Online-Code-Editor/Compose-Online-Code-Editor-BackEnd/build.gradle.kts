import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("multiplatform") version "1.9.23"
    id("org.jetbrains.compose") version "1.6.10-dev1523"
}

group = "com.example"
version = "0.0.1"


repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")

}
kotlin {
     sourceSets {
         js(IR) {
             browser()
             binaries.executable()
         }
         val jsMain by getting {
             kotlin.srcDir("src/main/kotlin")
             resources.srcDir("src/main/resources")

             dependencies {
                 implementation(compose.html.core)
                 implementation(compose.web.core)
                 implementation(compose.runtime)
             }
         }
         commonMain
         jvm()
        jsMain  {
            dependencies {
                // Import libraries
               implementation(compose.html.core)
                implementation(compose.runtime)
                implementation(compose.web.core)
            }
        }
        jsTest   {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
    jvmToolchain(11)
}
dependencies {

}
