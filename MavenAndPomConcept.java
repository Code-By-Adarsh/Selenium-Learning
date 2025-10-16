public class MavenAndPomConcept {
    public static void main(String[] args) {
        /*
        1️⃣ What is a Maven Project?
        -Maven is a build automation tool for Java projects. Think of it as a project manager that:
        -Downloads and manages all the libraries/dependencies your project needs.
        -Helps organize your project in a standard folder structure.
        -Makes it easy to build, test, and run your project automatically.
        -So, instead of manually downloading Selenium, TestNG, or any other library, Maven does it for you.

        2️⃣ What is pom.xml?
        -pom.xml stands for Project Object Model XML file.
        -It’s basically the heart of a Maven project. It contains:
        -Project info: Name, version, description, etc.
        -Dependencies: Libraries your project needs (like Selenium, TestNG, Rest-Assured).
        -Plugins: Extra tools for building, running tests, or generating reports.
        -Build settings: Compilation rules, source folders, test folders.

        💡 Example: Here’s a simple pom.xml for a Selenium + TestNG project:
        <project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/maven-v4_0_0.xsd">
                             <modelVersion>4.0.0</modelVersion>

        <groupId>com.company</groupId>
        <artifactId>AmazonAutomation</artifactId>
        <version>1.0-SNAPSHOT</version>
        <dependencies>
        <!-- Selenium Java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.16.0</version>
        </dependency>
        <!-- TestNG -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.9.0</version>
            <scope>test</scope>
        </dependency>
        </dependencies>
        </project>

        ✅ What this does:
        Maven automatically downloads Selenium and TestNG for you.
        You don’t have to manually add JARs in your project.
        When you move your project to another PC, it’ll still work—Maven handles everything.
         */
    }
}