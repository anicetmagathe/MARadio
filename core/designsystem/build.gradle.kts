plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.library.compose)
    alias(libs.plugins.convention.android.hilt)
}

android {
    namespace = "core.designsystem"
}

dependencies {
    implementation(libs.androidx.compose.material3)
    implementation(libs.coil.kt.compose)
    implementation(libs.androidx.material.icons.extended.android)
}