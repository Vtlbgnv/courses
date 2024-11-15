plugins {
	id("com.android.library")
	kotlin("android")
}

android {
	namespace = "com.example.courses.features.mainhost"
	compileSdk = 34

	defaultConfig {
		minSdk = 23
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}

	kotlinOptions {
		jvmTarget = "11"
	}

	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.3"
	}

	buildFeatures {
		compose = true
	}

	testOptions { unitTests.all { it.useJUnitPlatform() } }
}

dependencies {
	implementation (libs.compose.runTime)

	implementation(libs.cicerone)
	implementation(libs.fragment)

	implementation(libs.koin.core)
	implementation(libs.koin.android)

	implementation(libs.compose.activity)
	implementation(libs.compose.material)

	implementation(project(":core:navigation"))
	implementation(project(":components:ui"))

	implementation(libs.junit.api)
	implementation(libs.junit.engine)
	implementation(libs.mockito.inline)
	implementation(libs.mockito.core)
	implementation(libs.mockito.kotlin)
	implementation(libs.mockito.junit)
}