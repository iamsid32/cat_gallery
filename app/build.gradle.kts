import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.app.catgallery"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.catgallery"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        dataBinding = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeUIPeview)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.composeNavigation)
    implementation(Dependencies.composeViewModel)
    //hilt
    implementation(Dependencies.hiltAndroid)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.12")
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltAndroidCompiler)
    //hilt compose navigation
    implementation(Dependencies.hiltNavigationCompose)
    //retrofit and api network
    implementation(Dependencies.retrofit)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.loggingInterceptor)
    //coroutines
    implementation(Dependencies.coroutineCore)
    implementation(Dependencies.coroutineAndroid)
    //splash screen
    implementation(Dependencies.splashScreen)
    //coil (image library)
    implementation(Dependencies.coil)
    //coil gif
    implementation(Dependencies.coilGif)
    //runtime livedata
    implementation(Dependencies.runTimeLiveData)
    //compose material
    implementation(Dependencies.composeMaterial)
    //lottie
    implementation(Dependencies.lottie)


    implementation("org.mockito:mockito-core:5.3.1")

    // Core library
    testImplementation("org.mockito:mockito-core:5.3.1") // Use the latest version available

    // Kotlin extensions for Mockito
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0") // Use the latest version available

    // Testing LiveData and other architecture components
    testImplementation("androidx.arch.core:core-testing:2.2.0")

    // Kotlin Coroutines Test library
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3") // Use the latest version available

}

kapt{
    correctErrorTypes = true
}
