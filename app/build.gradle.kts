plugins {
    id("java")
    application
    checkstyle
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
application { mainClass.set("hexlet.code.App") }
dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.4")
    implementation ("info.picocli:picocli:4.7.6")
    annotationProcessor ("info.picocli:picocli-codegen:4.7.6")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.0.0-M4")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.4")
    testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.test {
    useJUnitPlatform()
}
tasks.jacocoTestReport {
    reports { xml.required.set(true)}
}