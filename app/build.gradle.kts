plugins {
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.5"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework:spring-context:6.1.0")
    implementation("org.springframework:spring-jdbc:6.1.0")
    implementation("org.springframework.data:spring-data-jdbc:3.3.0")
    implementation("com.h2database:h2:2.2.224")

    // --- TEST ---
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "co.edu.itc.programacion.biblioteca.BibliotecaApplication"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
