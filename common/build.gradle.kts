plugins {
    kotlin("multiplatform") version "1.3.41"
    id("kotlinx-serialization") version "1.3.41"
    id("maven-publish")
}

group =  "com.example"
version ="0.0.1"



kotlin {

    targets{
        android()
        val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos")
        if(onPhone!!){
            iosArm64("ios")
        }else{
            iosX64("ios")
        }
//        fromPreset(presets.jvm, 'jvm')
//
//        // Change to `presets.iosArm64` to deploy the app to iPhone
//        fromPreset(presets.iosX64, 'ios') {
//            compilations.main.outputKinds('FRAMEWORK')
//        }
    }
    sourceSets {
       val commonMain  by getting {
            dependencies {
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
        val iosMain by getting{
            dependencies{

            }
        }

    }
}

