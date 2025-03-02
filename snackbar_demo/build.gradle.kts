plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)

    kotlin("kapt")
}
android {
    namespace = "com.themobilecoder.snackbar_demo"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
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
        kotlinCompilerExtensionVersion = libs.versions.kotlin.compiler.extension.get()
    }
}

dependencies {
    implementation(libs.bundles.androidx.core)
    implementation(libs.bundles.androidx.compose)
    implementation(project(":core"))

    testImplementation(libs.junit.junit)
    testImplementation(libs.kotlin.coroutines.test)
    androidTestImplementation(libs.bundles.androidx.ui.test)

    debugImplementation(libs.bundles.androidx.compose.tooling)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.navigation.compose)

}

kapt {
    correctErrorTypes = true
}