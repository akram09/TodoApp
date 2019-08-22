import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins{
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}
android {
    compileSdkVersion(Configs.BuildVersion.target_sdk)
    defaultConfig {
        applicationId = "com.kero.todo"
        minSdkVersion(Configs.BuildVersion.min_sdk)
        targetSdkVersion(Configs.BuildVersion.target_sdk)
        versionCode =1
        versionName ="1.0"
        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
    }
    /*
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    testOptions.unitTests.all {
        testLogging {
            events 'passed', 'skipped', 'failed', 'standardOut', 'standardError'
        }
    }
    dataBinding{
        enabled true
    }
*/
}

dependencies {

    implementation(Dependencies.Android.constraint_layout)
    implementation(Dependencies.Android.appcompat)
    implementation(Dependencies.Kotlin.Jre)
    implementation(Dependencies.Kotlin.StdLib)

    /*
    implementation deps.android.constraint_layout
    implementation deps.android.lifecycle_extensions
    implementation deps.android.ktx_fragment
    implementation deps.android.fragment
    implementation deps.android.appcompat
    implementation deps.android.recyclerview
    implementation deps.android.design
    implementation deps.dagger.core
    implementation deps.dagger.support
    kapt deps.dagger.kaptCompiler
    kapt deps.dagger.kaptProcessor
    implementation deps.room.runtime
    implementation deps.kotlin.kotlin_jre
    implementation deps.kotlin.coroutines_core
    implementation deps.kotlin.coroutines_android
    implementation "io.reactivex.rxjava2:rxjava:2.2.4"
    implementation "io.reactivex.rxjava2:rxkotlin:2.3.0"
    implementation "io.reactivex.rxjava2:rxandroid:2.1.0"
    kapt deps.room.compiler

    testImplementation deps.test.junit
    testImplementation deps.test.mockk
    testImplementation deps.test.kotlin_junit */

}

