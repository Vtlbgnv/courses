plugins {
	id("com.android.library")
	kotlin("android")
	kotlin("kapt")
}

android {
	namespace = "com.example.courses.shared.favorites"
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
}

kapt {
	correctErrorTypes = true
}

dependencies {
	implementation(libs.room.runtime)
	kapt(libs.room.compiler)
	implementation(libs.room.ktx)
	implementation(libs.koin.core)
	implementation(libs.koin.android)
	implementation(libs.coroutine.core)
}