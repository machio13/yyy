import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
	java
	id("org.springframework.boot") version "3.4.5"
	id("io.spring.dependency-management") version "1.1.7"
	checkstyle
}

//group = "simplex.bn25.kaiden.june.murakami113004"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

val mockitoAgent: Configuration by configurations.creating

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:3.4.0")

	runtimeOnly("org.postgresql:postgresql")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	mockitoAgent("net.bytebuddy:byte-buddy-agent:1.17.5") {
		isTransitive = false
	}

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// テスト時の設定
tasks.withType<Test> {
	useJUnitPlatform()
	systemProperty("spring.profiles.active", "test,test-local")
}

// アプリ起動時のプロファイル設定
tasks.withType<BootRun> {
	systemProperty("spring.profiles.active", "local")
}

tasks.withType<Test> {
	jvmArgs("-javaagent:${mockitoAgent.singleFile.absolutePath}")
}
