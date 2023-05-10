group = rootProject.group
version = rootProject.version

val kotlinVersion: String by project
val springBootVersion: String by project
val kordVersion:String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("io.spring.dependency-management")
}

repositories {
    mavenCentral()

    maven { //the repository with core module
        url = uri("https://maven.pkg.github.com/ya0igoddess/skaard")
        credentials {
            username = System.getenv("USERNAME")
            password = System.getenv("TOKEN")
        }
    }
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    implementation("dev.kord:kord-core:$kordVersion")

    //skaard dependencies
    api("su.skaard:core:0.0.3")

    testImplementation("io.mockk:mockk-jvm:1.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}