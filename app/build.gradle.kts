plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
}

android {
	namespace = "com.example.courses"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.example.courses"
		minSdk = 23
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}

	viewBinding {
		enable = true
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}

	kotlinOptions {
		jvmTarget = "11"
	}

	testOptions { unitTests.all { it.useJUnitPlatform() } }

	packaging {
		resources {
			excludes += "/META-INF/LICENSE.md"
			excludes += "/META-INF/LICENSE-notice.md"
		}
	}
}

dependencies {
	implementation(libs.koin.core)
	implementation(libs.cicerone)
	implementation(libs.koin.android)
	implementation(libs.squareup.moshi)
	implementation(libs.squareup.moshiAdapters)


	implementation(project(":features:mainhost"))
	implementation(project(":features:profile"))
	implementation(project(":features:main:courses"))
	implementation(project(":core:navigation"))
	implementation(project(":core:network"))

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.navigation.fragment.ktx)

	implementation(libs.junit.api)
	implementation(libs.junit.engine)
	implementation(libs.mockito.inline)
	implementation(libs.mockito.core)
	implementation(libs.mockito.kotlin)
	implementation(libs.mockito.junit)
}