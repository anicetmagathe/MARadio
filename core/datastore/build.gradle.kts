plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.hilt)
}

android {
    namespace = "core.datastore"
}

dependencies {
    implementation(projects.core.datastoreProto)
    implementation(projects.core.async)

    implementation(libs.protobuf.javalite)
    implementation(libs.androidx.dataStore)
}