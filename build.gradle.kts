// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.1")  // Use a stable AGP version compatible with Gradle 8.7
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")  // Adjust Kotlin version if necessary
    }
}
