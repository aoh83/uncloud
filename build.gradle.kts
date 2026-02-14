plugins {
	java
	id("org.springframework.boot") version "4.0.2"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "monster.scalable"
version = "0.0.1-SNAPSHOT"
description = "data product console api server"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-liquibase")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
	// Source: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jdbc
	implementation("org.springframework.boot:spring-boot-starter-jdbc:4.0.2")
	// Source: https://mvnrepository.com/artifact/org.postgresql/postgresql
	implementation("org.postgresql:postgresql:42.7.10")



	testImplementation("org.springframework.boot:spring-boot-starter-liquibase-test")
	testImplementation("org.springframework.boot:spring-boot-starter-validation-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:testcontainers-junit-jupiter")
	// Source: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-test-autoconfigure
	testImplementation("org.springframework.boot:spring-boot-test-autoconfigure:4.0.2")
	// Source: https://mvnrepository.com/artifact/com.h2database/h2
	testImplementation("com.h2database:h2:2.4.240")
	testImplementation("org.testcontainers:testcontainers-postgresql:2.0.2")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
