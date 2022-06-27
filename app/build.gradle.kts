plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.HILT)
    kotlin(BuildPlugins.KOTLIN_ANDROID)
    kotlin(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.SAFE_ARGS)
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AndroidConfig.APPLICATION_ID
        minSdk = AndroidConfig.MIN_SDK
        targetSdk = AndroidConfig.TARGET_SDK
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(AndroidConfig.BuildType.RELEASE) {
            isMinifyEnabled = AndroidConfig.BuildTypeRelease.isMinifyEnable
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
        getByName(AndroidConfig.BuildType.DEBUG) {
            isMinifyEnabled = AndroidConfig.BuildTypeDebug.isMinifyEnable
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    // appcompat
    implementation(Libraries.appcompat)

    // coil
    implementation(Libraries.coil)

    // constraint
    implementation(Libraries.constraint)

    // jetpack
    implementation(Libraries.core)
    // lifecycle
    implementation(Libraries.compiler)
    implementation(Libraries.lifecycle)
    implementation(Libraries.livedata)
    implementation(Libraries.viewModel)
    // navigation
    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationUi)
    // paging
    implementation(Libraries.paging)
    // recycler view
    implementation(Libraries.recyclerview)
    // room
    implementation(Libraries.roomCore)
    implementation(Libraries.roomRuntime)
    kapt(Libraries.roomCompiler)

    // hilt
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltCompiler)
    kapt(Libraries.hiltExtCompiler)

    // kotlin coroutine
    implementation(Libraries.kotlinCoroutinesAndroid)
    implementation(Libraries.kotlinCoroutinesCore)

    // material
    implementation(Libraries.material)

    // lottie
    implementation(Libraries.lottieAnimation)

    // moshi
    implementation(Libraries.moshi)
    kapt(Libraries.moshiCodeGen)

    // okhttp
    implementation(Libraries.okhttpLoggingInterceptor)

    // retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitMoshiConverter)

    // swipe
    implementation(Libraries.swipe)

    // timber
    implementation(Libraries.timber)

    // espresso
    androidTestImplementation(Libraries.espresso)

    // junit
    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.junitExt)
}