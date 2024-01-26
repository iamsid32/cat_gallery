object Dependencies {

    val coreKtx by lazy { "androidx.core:core-ktx:1.12.0" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2" }
    val activityCompose by lazy { "androidx.activity:activity-compose:1.8.0" }
    val composeUI by lazy { "androidx.compose.ui:ui:1.2.0" }
    val composeUIPeview by lazy { "androidx.compose.ui:ui-tooling-preview:1.2.0" }
    val composeRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-compose:2.6.0" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3:1.2.0-alpha10" }
    val composeNavigation by lazy { "androidx.navigation:navigation-compose:2.7.4" }
    val composeViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2" }
    //hilt dagger
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:2.44.2" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:2.44.2" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:1.0.0-alpha01" }
    //hilt navigation compose
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03" }
    //retrofit and api call network related dependencies
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:2.9.0" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:5.0.0-alpha.11" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:2.9.0" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:1.15.0" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:2.9.0" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:4.9.0" }
    //coroutine
    val coroutineCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3" }
    val coroutineAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3" }
    //splash screen
    val splashScreen by lazy { "androidx.core:core-splashscreen:1.0.1" }
    //coil (image library)
    val coil by lazy { "io.coil-kt:coil-compose:2.2.0" }
    //coil (image library)
    val coilGif by lazy { "io.coil-kt:coil-gif:2.2.0" }
    //run time live data
    val runTimeLiveData by lazy { "androidx.compose.runtime:runtime-livedata:1.5.4" }
    //lifecycle extension
    val lifecycleExtension by lazy { "androidx.lifecycle:lifecycle-extensions:2.5.1" }
    //compose material
    val composeMaterial by lazy { "androidx.compose.material:material:1.3.0" }
    //lottie
    val lottie by lazy { "com.airbnb.android:lottie-compose:4.0.0" }

}


