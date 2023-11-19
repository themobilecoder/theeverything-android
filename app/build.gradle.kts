plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)

    kotlin("kapt")
}

android {
    namespace = "com.themobilecoder.theeverything_android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.themobilecoder.theeverything_android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.bundles.androidx.core)
    implementation(libs.bundles.androidx.compose)

    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.bundles.androidx.ui.test)

    debugImplementation(libs.bundles.androidx.compose.tooling)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.navigation.compose)

    //Modules:
    implementation(project(":core"))
    implementation(project(":snackbar_demo"))

}

kapt {
    correctErrorTypes = true
}