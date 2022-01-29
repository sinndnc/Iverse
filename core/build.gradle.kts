plugins {
    id(IdPlugin.hilt)
    id(IdPlugin.android)
    id(IdPlugin.library)
    kotlin(IdPlugin.kapt)
    id(IdPlugin.serialization)
}

android {
    compileSdk = Config.targetSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    //CORE
    implementation(Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.googleMaterial)
    //HILT
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    //COMPOSE
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.compose)
    //STORAGE
    implementation(Dependencies.dataStore)
    //KTOR
    implementation(Dependencies.ktorCio)
    implementation(Dependencies.ktorCore)
    implementation(Dependencies.jetBrainsKotlin)
    implementation(Dependencies.ktorSerialization)
    implementation(Dependencies.jetBrainSerialization)
    //TEST
    testImplementation(TestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.espresso)
}