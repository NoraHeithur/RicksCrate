object AndroidConfig {

    const val COMPILE_SDK = 32
    const val TARGET_SDK = 32
    const val MIN_SDK = 24

    const val versionCode = 1
    const val versionName = "1.0"

    const val APPLICATION_ID = "com.nora.rickscrate"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    interface BuildType {
        companion object {
            const val RELEASE = "release"
            const val DEBUG = "debug"
        }

        val isMinifyEnable: Boolean
    }

    object BuildTypeDebug : BuildType {
        override val isMinifyEnable: Boolean = false
    }

    object BuildTypeRelease : BuildType {
        override val isMinifyEnable: Boolean = false
    }
}