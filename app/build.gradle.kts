plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.mrpython.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mrpython.app"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"

        // Google's public test IDs: they always return test ads and earn nothing.
        resValue("string", "admob_app_id", "ca-app-pub-3940256099942544~3347511713")
        resValue("string", "admob_interstitial_id", "ca-app-pub-3940256099942544/1033173712")
    }

    // The upload key never lives in the repository: CI (or your own machine) passes it in
    // through environment variables. Without them the release build is simply left unsigned.
    val keystoreFile = System.getenv("MRPYTHON_KEYSTORE_FILE")
    signingConfigs {
        if (!keystoreFile.isNullOrBlank()) {
            create("release") {
                storeFile = file(keystoreFile)
                storePassword = System.getenv("MRPYTHON_KEYSTORE_PASSWORD")
                keyAlias = System.getenv("MRPYTHON_KEY_ALIAS")
                keyPassword = System.getenv("MRPYTHON_KEY_PASSWORD")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.findByName("release")
            // The real AdMob IDs come from the environment (repository secrets in CI). Debug
            // builds keep the test IDs on purpose: clicking your own live ads gets accounts banned.
            System.getenv("MRPYTHON_ADMOB_APP_ID")?.takeIf { it.isNotBlank() }
                ?.let { resValue("string", "admob_app_id", it) }
            System.getenv("MRPYTHON_ADMOB_INTERSTITIAL_ID")?.takeIf { it.isNotBlank() }
                ?.let { resValue("string", "admob_interstitial_id", it) }
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.play.billing)
    implementation(libs.play.services.ads)
    implementation(libs.ump)
    debugImplementation(libs.androidx.ui.tooling)

    testImplementation(libs.junit)
}
