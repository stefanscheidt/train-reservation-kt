import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    id("org.springframework.boot") version "2.2.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"

    id("org.unbroken-dome.test-sets") version "2.2.1"
    id("org.jlleitschuh.gradle.ktlint") version "9.1.1"
    id("org.jlleitschuh.gradle.ktlint-idea") version "9.1.1"
}

group = "katas"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

testSets {
    create("testInt") {
        dirName = "test-int"
    }
}

val testIntImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.implementation.get())
}

tasks.named("check") {
    dependsOn(
        tasks.named("ktlintCheck"),
        tasks.named("test"),
        tasks.named("testInt")
    )
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.github.microutils:kotlin-logging:1.7.8")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("org.assertj:assertj-core")

    testIntImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage")
        exclude(group = "org.mockito")
    }
    testIntImplementation("com.ninja-squad:springmockk:2.0.0")
    testIntImplementation(sourceSets.test.get().output)
}
