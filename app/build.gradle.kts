group = rootProject.group
version = rootProject.version
java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
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

    //skaard dependencies
    implementation(project(":template-module"))

    runtimeOnly("org.postgresql:postgresql:42.3.8")
}