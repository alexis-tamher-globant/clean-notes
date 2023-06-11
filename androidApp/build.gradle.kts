plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.alexdev.cleannotes.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.alexdev.cleannotes.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {

    implementation(project(":shared"))
    val composVersion = "1.2.1"
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:$composVersion")
    implementation("androidx.compose.ui:ui-tooling:$composVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composVersion")
    implementation("androidx.compose.foundation:foundation:$composVersion")
    implementation("androidx.compose.material:material:$composVersion")
    implementation("androidx.activity:activity-compose:1.5.1")

    implementation(Kotlin.DateTime)
    implementation(Koin.Core)
    implementation(Koin.Android)
    implementation(Koin.AndroidCompose)

    implementation(Navigation.Compose)
    implementation(LifeCycle.ViewModelKtx)
}