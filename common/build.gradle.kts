
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
                implementation(Dependencies.Coroutines.core)
                implementation(kotlin("stdlib-common"))
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

            }
        }

    }

}



