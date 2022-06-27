pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

/*    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application", "com.android.library" -> {
                    useModule("com.android.tools.build.gradle:7.2.1")
                }
                "androidx.navigation.safeargs.kotlin" -> {
                    useModule("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
                }
                "dagger.hilt.android.plugin" -> {
                    useModule("com.google.dagger:hilt-android-gradle-plugin:2.42")
                }
            }
        }
    }*/
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Rick's crate"
include(":app")