
object Dependencies {


    object Coroutines {
         val core ="org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutine_version}"
         val Android ="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutine_version}"
         val Native = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.Kotlin.coroutine_version}"
         val rxJava = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.Kotlin.coroutine_version}"
    }

    object Rxjava {
         val core = "io.reactivex.rxjava2:rxjava:${Versions.Kotlin.rxJava}"
         val rxKotlin= "io.reactivex.rxjava2:rxkotlin:${Versions.Kotlin.rxKotlin}"
    }
    object Kotlin{
         val Jre = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.kotlinVersion}"
         val StdLib ="org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlinVersion}"
    }
    object  Serialization {
         val Common = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Versions.Kotlin.SerializationVersion}"
         val Jvm = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.Kotlin.SerializationVersion}"
         val Native = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:${Versions.Kotlin.SerializationVersion}"
    }
    object Koin {
         val Core = "org.koin:koin-core:${Versions.Kotlin.KoinVersion}"
         val Extensions= "org.koin:koin-core-ext:${Versions.Kotlin.KoinVersion}"
         val Ktor = "org.koin:koin-ktor:${Versions.Kotlin.KoinVersion}"
         val Test = "org.koin:koin-test:${Versions.Kotlin.KoinVersion}"
    }
    object Test{
        object Junit{
             val Jupiter = "org.junit.jupiter:junit-jupiter-api:${Versions.Kotlin.junit}"
             val KotlinJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.Kotlin.kotlinVersion}"
        }
        const val mockk = "io.mockk:mockk:1.8.9.kotlin13"
    }
    object Ktor {
         val Netty = "io.ktor:ktor-server-netty:${Versions.Ktor.ktor_version}"
         val logback = "ch.qos.logback:logback-classic:${Versions.Ktor.logback_version}"
         val Core = "io.ktor:ktor-server-core:${Versions.Ktor.ktor_version}"
         val CioServer =  "io.ktor:ktor-server-cio:${Versions.Ktor.ktor_version}"
         val HtmlBuilder = "io.ktor:ktor-html-builder:${Versions.Ktor.ktor_version}"
         val Jackson =  "io.ktor:ktor-jackson:${Versions.Ktor.ktor_version}"
         val Auth =  "io.ktor:ktor-auth:${Versions.Ktor.ktor_version}"
         val AuthJwt =  "io.ktor:ktor-auth-jwt:${Versions.Ktor.ktor_version}"
         val Gson =  "io.ktor:ktor-gson:${Versions.Ktor.ktor_version}"
         val serverTest=  "io.ktor:ktor-server-tests:${Versions.Ktor.ktor_version}"
    }
     val Exposed = "org.jetbrains.exposed:exposed:${Versions.Ktor.exposed}"
     val HickariCp = "com.zaxxer:HikariCP:${Versions.Ktor.hickariCp}"
     val H2Db = "com.h2database:h2:${Versions.Ktor.h2}"

    object KtorClient{
         val commonCore = "io.ktor:ktor-client-core:${Versions.Ktor.ktor_version}"
         val jvmCore = "io.ktor:ktor-client-core-jvm:${Versions.Ktor.ktor_version}"
         val iosCore = "io.ktor:ktor-client-ios:${Versions.Ktor.ktor_version}"
         val commenJson="io.ktor:ktor-client-json:${Versions.Ktor.ktor_version}"
         val jvmJso="io.ktor:ktor-client-json-jvm:${Versions.Ktor.ktor_version}"
         val iosJson = "io.ktor:ktor-client-json-native:${Versions.Ktor.ktor_version}"
         val iosNative = "io.ktor:ktor-client-core-native:${Versions.Ktor.ktor_version}"
    }

    object Android {
         val appcompat = "androidx.appcompat:appcompat:${Versions.Android.appcompat}"
         val fragment = "androidx.fragment:fragment:${Versions.Android.appcompat}"
         val recyclerview = "androidx.recyclerview:recyclerview:${Versions.Android.appcompat}"
         val design = "com.google.android.material:material:${Versions.Android.design}"
         val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.Android.constraint_layout}"
         val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.Android.lifecycle}"
         val ktx_fragment = "androidx.fragment:fragment-ktx:${Versions.Android.ktx_fragment}"
         val rxAndroid= "io.reactivex.rxjava2:rxandroid:${Versions.Android.rxAndroid}"
        object Room {
             val runtime = "androidx.room:room-runtime:${Versions.Android.room}"
             val compiler = "androidx.room:room-compiler:${Versions.Android.room}"
        }

        object Dagger {
             val core= "com.google.dagger:dagger-android:${Versions.Android.dagger}"
             val support= "com.google.dagger:dagger-android-support:${Versions.Android.dagger}"
             val kaptCompiler= "com.google.dagger:dagger-compiler:${Versions.Android.dagger}"
             val kaptProcessor= "com.google.dagger:dagger-android-processor:${Versions.Android.dagger}"
        }
    }


}