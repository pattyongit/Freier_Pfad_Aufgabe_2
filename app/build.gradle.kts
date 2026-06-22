plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.freier_pfad_aufgabe_2"
    compileSdk = 37 // Ganz simpel als Zahl geschrieben

    defaultConfig {
        applicationId = "com.example.freier_pfad_aufgabe_2"
        minSdk = 24
        targetSdk = 37 // Auch direkt auf 37 angehoben, damit es zum compileSdk passt
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Das ist die stabilere Standard-Schreibweise
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}