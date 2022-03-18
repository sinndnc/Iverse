object Dependencies {
    //CORE
    const val core = "androidx.core:core-ktx:${Versions.CORE_VERSION}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.APPCOMPAT_VERSION}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}"

    //GOOGLE
    const val googleMaterial = "com.google.android.material:material:${Versions.APPCOMPAT_VERSION}"
    const val googleServices = "com.google.android.gms:play-services-auth:${Versions.GOOGLE_SERVICES}"
    const val googlePhoneServices = "com.google.android.gms:play-services-auth-api-phone:${Versions.GOOGLE_PHONE_SERVICES}"

    //FIREBASE
    const val firebaseBom = "com.google.firebase:firebase-bom:29.2.0"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
    const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"


    //STORAGE
    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.DATASTORE_VERSION}"

    //STORAGE(must have alias key)
    const val encryptedPreference = "androidx.security:security-crypto:${Versions.ENCRYPTED_VERSION}"

    //COMPOSE
    const val compose = "androidx.activity:activity-compose:${Versions.APPCOMPAT_VERSION}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.COMPOSE_VERSION}"
    const val composeCoil = "io.coil-kt:coil-compose:${Versions.COIL_VERSION}"
    const val composeUtil = "androidx.compose.ui:ui-util:${Versions.COMPOSE_VERSION}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.COMPOSE_VERSION}"
    const val composeLivedata = "androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE_VERSION}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_VERSION}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.COMPOSE_VERSION}"

    //ACCOMPANIST
    const val composeSystemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.ACCOMPANIST_VERSION}"
    const val composeInset = "com.google.accompanist:accompanist-insets:${Versions.ACCOMPANIST_VERSION}"
    const val composeInsetUi = "com.google.accompanist:accompanist-insets-ui:${Versions.ACCOMPANIST_VERSION}"

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