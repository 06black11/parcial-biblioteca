

plugins {
    
    application

    
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

repositories {
    
    mavenCentral()
}

dependencies {
    
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

    
    runtimeOnly("com.h2database:h2")

   
    implementation("org.springframework.boot:spring-boot-starter-logging")

    
    implementation("com.google.guava:guava:33.2.0-jre")

    
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
       
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
   
    mainClass = "co.edu.itc.programacion.biblioteca.Main"
}

tasks.named<Test>("test") {
   
    useJUnitPlatform()
}
