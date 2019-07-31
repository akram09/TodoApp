buildscript {
    repositories {
    google()
    jcenter()
    mavenLocal()
    mavenCentral()
    maven {  "https://jitpack.io" }
    maven {  "https://kotlin.bintray.com/ktor" }
    maven { "https://dl.bintray.com/netguru/maven/" }
    maven { "https://dl.bintray.com/kotlin/kotlinx" }
    maven {  "https://dl.bintray.com/arrow-kt/arrow-kt/" }
    maven {  "https://kotlin.bintray.com/kotlin-js-wrappers" }
    maven {  "https://oss.sonatype.org/content/repositories/snapshots" }
    maven { "https://dl.bintray.com/kotlin/kotlin-eap" }
        }

    dependencies {
        classpath( ClassPaths.Serialization)
        classpath(ClassPaths.KotlinGradlePlugin)
        classpath(ClassPaths.AndroidGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenLocal()
        mavenCentral()
        maven { "https://jitpack.io" }
        maven {"https://kotlin.bintray.com/ktor" }
        maven { "https://dl.bintray.com/netguru/maven/" }
        maven { "https://dl.bintray.com/kotlin/kotlinx" }
        maven { "https://dl.bintray.com/arrow-kt/arrow-kt/" }
        maven { "https://kotlin.bintray.com/kotlin-js-wrappers" }
        maven { "https://oss.sonatype.org/content/repositories/snapshots" }
        maven { "https://dl.bintray.com/kotlin/kotlin-eap" }
    }

}