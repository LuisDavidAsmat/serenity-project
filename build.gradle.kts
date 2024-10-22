plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))

    // JUnit dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.2")

    // Serenity dependencies
    implementation("net.serenity-bdd:serenity-core:4.1.14")
    testImplementation("net.serenity-bdd:serenity-junit5:4.1.14")

    // SLF4J API
    implementation("org.slf4j:slf4j-api:2.0.7")

    // SLF4J binding for logback
    testImplementation("ch.qos.logback:logback-classic:1.5.6")

    // Serenity reporting
    implementation("net.serenity-bdd:serenity-reports:4.1.14")

    // Serenity Screenplay
    implementation("net.serenity-bdd:serenity-screenplay:4.1.14")
    implementation("net.serenity-bdd:serenity-screenplay-webdriver:4.1.14")

    // Ensure
    testImplementation("net.serenity-bdd:serenity-ensure:4.1.14")

    // Assertj
    testImplementation("org.assertj:assertj-core:3.26.3")

    // Selenium
    //implementation("org.seleniumhq.selenium:selenium-devtools-v120:4.18.1")

    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-firefox-driver
    implementation("org.seleniumhq.selenium:selenium-firefox-driver:4.25.0")
}

tasks.test {
    useJUnitPlatform()
}