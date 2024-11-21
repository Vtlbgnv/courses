plugins {
	id("com.android.library")
	kotlin("android")
}

android {
	namespace = "com.example.courses.features.userfavorites"
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
}

dependencies {
	implementation(libs.compose.runTime)
	implementation(libs.compose.material)
	implementation(libs.compose.tooling)
	implementation(libs.compose.studoPreview)

	implementation(libs.squareup.retrofit)
	implementation(libs.squareup.moshi)

	implementation(libs.material)

	implementation(libs.fragment)

	implementation(libs.koin.core)
	implementation(libs.koin.android)

	implementation(project(":core:navigation"))
	implementation(project(":core:network"))
	implementation(project(":components:ui"))
	implementation(project(":components:presentation"))
	implementation(project(":shared:favorites"))
}