plugins {
	id("com.android.library")
	kotlin("android")
	kotlin("kapt")

}
android {
	namespace = "com.example.courses.core.network"
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

	testOptions { unitTests.all { it.useJUnitPlatform() } }

}



dependencies {
	implementation(libs.squareup.moshi)
	implementation(libs.squareup.moshiAdapters)
	implementation(libs.squareup.moshiRetrofit)
	kapt(libs.squareup.moshiCodegen)

	implementation(libs.squareup.okhttpInterceptor)

	implementation(libs.squareup.retrofitScalars)
	implementation(libs.squareup.retrofit)
	implementation(libs.koin.core)
	implementation(libs.koin.android)

	implementation(libs.junit.api)
	implementation(libs.junit.engine)
	implementation(libs.mockito.inline)
	implementation(libs.mockito.core)
	implementation(libs.mockito.kotlin)
	implementation(libs.mockito.junit)
	implementation(libs.turbine)
	implementation(libs.coroutineTest)


}