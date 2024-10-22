import org.gradle.accessors.dm.LibrariesForLibs

/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Apply the java Plugin to add support for Java.
    java
}


tasks.compileJava {
    options.encoding =  "UTF-8"; //todo_lh 抽取公共变量使用的方式
}

repositories {
    maven {
        url = uri("https://maven.aliyun.com/repository/public")
    }

    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

val libs = the<LibrariesForLibs>()
dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    testCompileOnly(libs.lombok)
    testAnnotationProcessor(libs.lombok)

}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
