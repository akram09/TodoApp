
plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
    id("org.jetbrains.kotlin.native.cocoapods")
    id("co.touchlab.kotlinxcodesync")
}
kotlin {

    jvm()
    targets {
        val  buildForDevice = project.findProperty("kotlin.native.cocoapods.target") == "ios_arm"
        if (buildForDevice) {
            iosArm64("iOS64")
            iosArm32("iOS32")
        } else {
            iosX64("iOS")
        }
    }

    sourceSets {
       val commonMain  by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(Dependencies.Coroutines.core)
                implementation(project(":common"))
                implementation(Dependencies.Serialization.Common)
                implementation(Dependencies.KtorClient.commenJson)
                implementation(Dependencies.KtorClient.commonCore)

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-commone"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmMain  by getting{
            dependencies {
                implementation(kotlin("stdlib"))
                implementation(Dependencies.Coroutines.Android)
                implementation(Dependencies.Serialization.Jvm)
                implementation(Dependencies.KtorClient.jvmCore)
                implementation(Dependencies.KtorClient.jvmJso)
            }
        }
        val jvmTest  by getting{
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }

        val iOSMain by getting{
            dependencies{
                implementation(Dependencies.Coroutines.Native)
                implementation(Dependencies.Serialization.Native)
                implementation(Dependencies.KtorClient.iosCore)
                implementation(Dependencies.KtorClient.iosJson)
                implementation(Dependencies.KtorClient.iosNative)
            }
        }

    }

    cocoapods {
        summary = "Kotlin TodoList App common module"
        homepage = "https://github.com/akram09/TodoApp"
    }

}


xcode {
    projectPath = "../ios/TodoApp.xcodeproj"
    target = "TodoApp"
}


