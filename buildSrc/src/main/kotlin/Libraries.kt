object Libraries {

    // gradle plugin
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Version.androidGradle}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val navigationGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.androidxNavigation}"

    // AppCompat
    const val appcompat = "androidx.appcompat:appcompat:${Version.androidxAppCompat}"

    // Jetpack
    const val core = "androidx.core:core:${Version.androidxCore}"
    const val compiler = "androidx.lifecycle:lifecycle-compiler:${Version.androidxLifeCycle}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.androidxLifeCycle}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.androidxLifeCycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.androidxLifeCycle}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.androidxNavigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.androidxNavigation}"
    const val paging = "androidx.paging:paging-runtime:${Version.androidxPaging}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Version.androidxRecyclerView}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomCore = "androidx.room:room-ktx:${Version.room}"
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"

    // Coil
    const val coil = "io.coil-kt:coil:${Version.coil}"

    // Constraint
    const val constraint = "androidx.constraintlayout:constraintlayout:${Version.androidxConstraintLayout}"

    // Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
    const val hiltExtCompiler = "androidx.hilt:hilt-compiler:${Version.hiltExt}"

    // Kotlin
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlinxCoroutines}"
    const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinxCoroutines}"

    // Lottie
    const val lottieAnimation = "com.airbnb.android:lottie:${Version.lottieAnimation}"

    // Material design
    const val material = "com.google.android.material:material:${Version.material}"

    // Moshi
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"
    const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Version.moshi}"

    // okhttp
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"

    // retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"

    // swipe
    const val swipe = "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipe}"

    // timber
    const val timber = "com.jakewharton.timber:timber:${Version.timber}"

    // testing
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val junit = "junit:junit:${Version.junit}"
    const val junitExt = "androidx.test.ext:junit:${Version.junitExt}"
}