import sun.misc.Version

object Dependencies {


    object Coroutines {
        const val core ="org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutine_version}"
        const val Android ="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutine_version}"
        const val Native = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.Kotlin.coroutine_version}"
        const val rxJava = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.Kotlin.coroutine_version}"
    }

    object Rxjava {
        const val core = "io.reactivex.rxjava2:rxjava:${Versions.Kotlin.rxJava}"
        const val rxKotlin= "io.reactivex.rxjava2:rxkotlin:${Versions.Kotlin.rxKotlin}"
    }
    object Kotlin{
        const val Jre = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.kotlinVersion}"
        const val StdLib ="org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlinVersion}"
    }
    object  Serialization {
        const val Common = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Versions.Kotlin.SerializationVersion}"
        const val Jvm = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.Kotlin.SerializationVersion}"
        const val Native = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:${Versions.Kotlin.SerializationVersion}"
    }
    object Arrow {
        const val Core = "io.arrow-kt:arrow-core:${Versions.Kotlin.arrowVersion}"
    }
    object Koin {
        const val Core = "org.koin:koin-core:${Versions.Kotlin.KoinVersion}"
        const val Extensions= "org.koin:koin-core-ext:${Versions.Kotlin.KoinVersion}"
        const val Ktor = "org.koin:koin-ktor:${Versions.Kotlin.KoinVersion}"
        const val Test = "org.koin:koin-test:${Versions.Kotlin.KoinVersion}"
    }
    object Test{
        object Junit{
            const val Jupiter = "org.junit.jupiter:junit-jupiter-api:${Versions.Kotlin.junit}"
            const val KotlinJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.Kotlin.kotlinVersion}"
        }
        const val mockk = "io.mockk:mockk:1.8.9.kotlin13"
    }
    object Ktor {
        const val Netty = "io.ktor:ktor-server-netty:${Versions.Ktor.ktor_version}"
        const val logback = "ch.qos.logback:logback-classic:${Versions.Ktor.logback_version}"
        const val Core = "io.ktor:ktor-server-core:${Versions.Ktor.ktor_version}"
        const val CioServer =  "io.ktor:ktor-server-cio:${Versions.Ktor.ktor_version}"
        const val HtmlBuilder = "io.ktor:ktor-html-builder:${Versions.Ktor.ktor_version}"
        const val Jackson =  "io.ktor:ktor-jackson:${Versions.Ktor.ktor_version}"
        const val Auth =  "io.ktor:ktor-auth:${Versions.Ktor.ktor_version}"
        const val AuthJwt =  "io.ktor:ktor-auth-jwt:${Versions.Ktor.ktor_version}"
        const val Gson =  "io.ktor:ktor-gson:${Versions.Ktor.ktor_version}"
        const val serverTest=  "io.ktor:ktor-server-tests:${Versions.Ktor.ktor_version}"
    }
    const val Exposed = "org.jetbrains.exposed:exposed:${Versions.Ktor.exposed}"
    const val HickariCp = "com.zaxxer:HikariCP:${Versions.Ktor.hickariCp}"
    const val H2Db = "com.h2database:h2:${Versions.Ktor.h2}"

    object KtorClient{
        const val commonCore = "io.ktor:ktor-client-core:${Versions.Ktor.ktor_version}"
        const val jvmCore = "io.ktor:ktor-client-core-jvm:${Versions.Ktor.ktor_version}"
        const val iosCore = "io.ktor:ktor-client-ios:${Versions.Ktor.ktor_version}"
        const val commenJson="io.ktor:ktor-client-json:${Versions.Ktor.ktor_version}"
        const val jvmJso="io.ktor:ktor-client-json-jvm:${Versions.Ktor.ktor_version}"
        const val iosJson = "io.ktor:ktor-client-json-native:${Versions.Ktor.ktor_version}"
        const val iosNative = "io.ktor:ktor-client-core-native:${Versions.Ktor.ktor_version}"
    }

    object Android {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.Android.appcompat}"
        const val fragment = "androidx.fragment:fragment:${Versions.Android.appcompat}"
        const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.Android.appcompat}"
        const val design = "com.google.android.material:material:${Versions.Android.design}"
        const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.Android.constraint_layout}"
        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.Android.lifecycle}"
        const val ktx_fragment = "androidx.fragment:fragment-ktx:${Versions.Android.ktx_fragment}"
        const val rxAndroid= "io.reactivex.rxjava2:rxandroid:${Versions.Android.rxAndroid}"
        object Room {
            const val runtime = "androidx.room:room-runtime:${Versions.Android.room}"
            const val compiler = "androidx.room:room-compiler:${Versions.Android.room}"
        }

        object Dagger {
            const val core= "com.google.dagger:dagger-android:${Versions.Android.dagger}"
            const val support= "com.google.dagger:dagger-android-support:${Versions.Android.dagger}"
            const val kaptCompiler= "com.google.dagger:dagger-compiler:${Versions.Android.dagger}"
            const val kaptProcessor= "com.google.dagger:dagger-android-processor:${Versions.Android.dagger}"
        }
    }


}