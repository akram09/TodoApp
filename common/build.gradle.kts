
plugins {
    kotlin("multiplatform")
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
                implementation(Dependencies.Stately.mpp)
                implementation(Dependencies.Stately.collection)
                implementation(Dependencies.Kotlin.StdLib)
                implementation(Dependencies.Kotlin.Jre)
                implementation(Dependencies.Coroutines.core)
                implementation(Dependencies.SqlDelight.runtime)
                implementation(Dependencies.multiplatformSettings)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Dependencies.Test.mockk)
                implementation(Dependencies.Test.Kotlin.common)
                implementation(Dependencies.Test.Kotlin.annotation)
                implementation(Dependencies.Stately.mpp)
                implementation(Dependencies.Stately.collection)
                implementation(Dependencies.Coroutines.core)
                implementation(Dependencies.Coroutines.JDK)
                implementation(Dependencies.multiplatformSettings)
            }
        }

        val jvmMain  by getting{
            dependencies {
                implementation(Dependencies.Kotlin.StdLib)
                implementation(Dependencies.Kotlin.Jre)
            }
        }
        val jvmTest  by getting{
            dependencies {
                implementation(Dependencies.Test.Junit.KotlinJunit)
                implementation(Dependencies.Test.Kotlin.jvm)
            }
        }
        val iOSMain by getting{
            dependencies{

            }
        }

    }

}



