buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugin.androidPlugin)
        classpath(BuildPlugin.kotlinPlugin)
        classpath(BuildPlugin.hiltPlugin)
        classpath(BuildPlugin.SerializationPlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}