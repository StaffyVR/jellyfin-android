plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "org.jellyfin.player.mpv"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    implementation(project(":mpvlib"))
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
    implementation("androidx.media3:media3-common:1.4.1")
}
