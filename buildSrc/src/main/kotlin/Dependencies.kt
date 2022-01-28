object Dependencies {
    //CORE
    const val core = "androidx.core:core-ktx:${Versions.CORE_VERSION}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.APPCOMPAT_VERSION}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}"

    //GOOGLE
    const val googleMaterial = "com.google.android.material:material:${Versions.APPCOMPAT_VERSION}"
    const val googleServices = "com.google.android.gms:play-services-auth:${Versions.GOOGLE_SERVICES}"
    const val googlePhoneServices = "com.google.android.gms:play-services-auth-api-phone:${Versions.GOOGLE_PHONE_SERVICES}"

    //STORAGE(must have alias key)
    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.DATASTORE_VERSION}"

    //STORAGE
    const val encryptedPreference = "androidx.security:security-crypto:${Versions.ENCRYPTED_VERSION}"

    //COMPOSE
    const val compose = "androidx.activity:activity-compose:${Versions.APPCOMPAT_VERSION}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.COMPOSE_VERSION}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.COMPOSE_VERSION}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_VERSION}"

    //NAVIGATION
    const val navigation = "androidx.navigation:navigation-compose:${Versions.NAVIGATION_VERSION}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION_VERSION}"

    //HILT
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.HILT_VERSION}"

    //KTOR
    const val ktorCore = "io.ktor:ktor-client-core:${Versions.KTOR_VERSION}"
    const val ktorCio = "io.ktor:ktor-client-cio:${Versions.KTOR_VERSION}"
    const val ktorSerialization = "io.ktor:ktor-client-serialization:${Versions.KTOR_VERSION}"

    //JETBRAINS
    const val jetBrainsKotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN_VERSION}"
    const val jetBrainSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
}