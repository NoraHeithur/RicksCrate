// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Libraries.androidGradlePlugin)
        classpath(Libraries.kotlinGradlePlugin)
        classpath(Libraries.hiltGradlePlugin)
        classpath(Libraries.navigationGradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}