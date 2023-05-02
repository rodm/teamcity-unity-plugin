
plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
    implementation("io.github.rodm:gradle-teamcity-plugin:1.5")
}
