plugins {
    kotlin("jvm")
}

group = "me.alexa"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.0")
}