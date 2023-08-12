plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

java { toolchain { languageVersion.set(JavaLanguageVersion.of(17)) } }

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    // Define the main class for the application.
    mainClass.set("solution.Solution")
}

tasks.withType<JavaCompile> { options.isWarnings = true }

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
