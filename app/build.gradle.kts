plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    // Existing plugins
    alias(libs.plugins.compose.compiler) apply true
}

android {
    namespace = "com.example.quantom"
    compileSdk = 35
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    defaultConfig {
        applicationId = "com.example.quantom"
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
}


//.
dependencies {
//This dependency integrates Jetpack Compose with the Activity class, enabling the use of Compose in Android activities.
    implementation(libs.androidx.activity.compose)
//Compose Bill of Materials (BOM), which helps manage versions of Compose libraries. In this case, it's using version 2023.03.00 for Compose dependencies.
    implementation(platform(libs.androidx.compose.bom))
//This dependency includes the fundamental UI elements and features provided by Jetpack Compose.
    implementation(libs.androidx.ui)
//This includes tooling and preview functionalities for Compose, assisting with development and debugging UI components.
    implementation(libs.androidx.ui.tooling.preview)
//This dependency includes the Material Design 3 components and styles adapted for Jetpack Compose, allowing the implementation of Material Design principles in your app's UI
    implementation(libs.androidx.material3)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}