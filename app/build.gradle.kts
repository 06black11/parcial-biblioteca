plugins {
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.5"
    application
}

repositories {
    mavenCentral()
}

dependencies {

    // --- SPRING WEB ---
    implementation("org.springframework.boot:spring-boot-starter-web")

    // --- SPRING DATA JDBC ---
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    // --- H2 DATABASE ---
    implementation("com.h2database:h2:2.4.240")

    // --- LOMBOK (opcional pero recomendado) ---
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

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
