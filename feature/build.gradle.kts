plugins {
    id(IdPlugin.android)
    id(IdPlugin.library)
    kotlin(IdPlugin.kapt)
    id(IdPlugin.hilt)
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
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_VERSION
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
    implementation("com.jakewharton.timber:timber:5.0.1")
    //MODULE
    implementation(project(mapOf("path" to ":core")))
    //COMPOSE
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.compose)
    implementation(Dependencies.composeLivedata)
    //NAVIGATION
    implementation(Dependencies.hiltNavigation)
    implementation(Dependencies.navigation)
    //HILT
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    //GOOGLE
    implementation(Dependencies.googleServices)
    implementation(Dependencies.googlePhoneServices)
    //CORE
    implementation(Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.googleMaterial)
    //TEST
    testImplementation(TestDependencies.junit)
    debugImplementation(DebugDependencies.compose)
    androidTestImplementation(AndroidTestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.espresso)
}