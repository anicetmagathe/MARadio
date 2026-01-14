plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.hilt)
}

android {
    namespace = "core.network"
}

dependencies {
    implementation(libs.radiobrowser4j)
}