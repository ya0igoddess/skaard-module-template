group = rootProject.group
version = rootProject.version
java.sourceCompatibility = JavaVersion.VERSION_17

val kotlinVersion: String by project
val kordVersion: String by project

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.jpa")
    kotlin("jvm")
    kotlin("plugin.spring")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { //the repository with core module
        url = uri("https://maven.pkg.github.com/ya0igoddess/skaard")
        credentials {
            username = System.getenv("USERNAME")
            password = System.getenv("TOKEN")
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    //skaard dependencies
    implementation(project(":template-module"))

    testImplementation("io.mockk:mockk-jvm:1.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}


