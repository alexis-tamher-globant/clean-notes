plugins {
    val gradleVersion = "7.2.2"
    val kotlinVersion = "1.7.10"
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version(gradleVersion).apply(false)
    id("com.android.library").version(gradleVersion).apply(false)
    kotlin("android").version(kotlinVersion).apply(false)
    kotlin("multiplatform").version(kotlinVersion).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
