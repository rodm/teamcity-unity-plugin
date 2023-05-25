
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.text.SimpleDateFormat
import java.util.Date

plugins {
    id ("org.jetbrains.kotlin.jvm")
}

repositories {
    mavenCentral()
}

group = "teamcity-unity-plugin"

val defaultVersion = "SNAPSHOT_${SimpleDateFormat("yyyyMMddHHmmss").format(Date())}"
val versionNumber = project.findProperty("versionNumber") ?: ""
val validVersion = Regex("\\d+(\\.\\d+\\.\\d+.*)?").matches(versionNumber.toString())
version = if (validVersion) versionNumber else defaultVersion

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks {
    test {
        useTestNG()
    }
    jar {
        version = null
    }
}
