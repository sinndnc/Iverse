buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugin.firebasePlugin)
        classpath(BuildPlugin.androidPlugin)
        classpath(BuildPlugin.kotlinPlugin)
        classpath(BuildPlugin.hiltPlugin)
        classpath(BuildPlugin.serializationPlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}