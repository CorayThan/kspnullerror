import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    val kotlinVersion = "2.1.0"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion

    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "graylakegames"
version = "test"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xjsr305=strict",
            "-opt-in=kotlin.ExperimentalStdlibApi"
        )
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

springBoot {
    mainClass.set("graylakegames.test.TestAppKt")
}

repositories {
    mavenCentral()
}

dependencies {

    val hibernateVersion = "6.5.3.Final"
    val queryDslVersion = "6.9"

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.hibernate:hibernate-core:$hibernateVersion")

    implementation("io.github.openfeign.querydsl:querydsl-core:$queryDslVersion")
    ksp("io.github.openfeign.querydsl:querydsl-ksp-codegen:$queryDslVersion")

    implementation("com.h2database:h2:2.3.232")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
