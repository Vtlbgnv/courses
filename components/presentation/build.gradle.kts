plugins {
	id("com.android.library")
	kotlin("android")
}
android {
	namespace = "com.example.courses.components.presentation"
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

dependencies {
	implementation(libs.jsoup)
	implementation(libs.coroutine.android)
	implementation(libs.lifeCycleViewModelKtx)
}