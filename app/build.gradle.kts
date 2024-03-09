plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.example.restfull_study"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.restfull_study"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Hilt (DI)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.android)

    // Retrofit & OkHttp (Network)
    implementation(libs.retrofit2.retrofit)
    implementation(libs.retrofit2.converter.kotlinx)
    implementation(libs.okhttp3.okhttp)

    // Kotlin Coroutines (Async)
    implementation(libs.kotlinx.coroutines)

    // Kotlin Serialization (Serialization)
    implementation(libs.kotlinx.serialization)

    // Glide (Load Image)
    implementation(libs.glide)

    // Navigation Component (Navigation)
    implementation(libs.nav.fragment)
    implementation(libs.nav.ui)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}