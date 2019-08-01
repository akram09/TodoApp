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
                implementation(Dependencies.Coroutines.core)
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
        val iosMain by getting{
            dependencies{
                implementation(Dependencies.Coroutines.Native)
                implementation(Dependencies.Serialization.Native)
                implementation(Dependencies.KtorClient.iosCore)
                implementation(Dependencies.KtorClient.iosJson)
                implementation(Dependencies.KtorClient.iosNative)
            }
        }

    }
}

