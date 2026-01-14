import mg.anet.template.VersionInfo

plugins {
    alias(libs.plugins.convention.android.application)
    alias(libs.plugins.convention.android.application.compose)
    alias(libs.plugins.convention.android.hilt)
    alias(libs.plugins.convention.application.version)
}

android {
    namespace = "com.anet"

    defaultConfig {
        applicationId = "com.anet"
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

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

appVersionExtension {
    name = "App"
    version = VersionInfo(0, 0, 1)
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.ui)

    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.core.splashscreen)
}