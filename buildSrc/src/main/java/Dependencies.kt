object Dependencies {


    object Coroutines {
        const val core ="org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutine_version}"
        const val Android ="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutine_version}"
        const val Native = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.Kotlin.coroutine_version}"
        const val rxJava = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.Kotlin.coroutine_version}"
    }



    def rxjava =[:]
    rxjava.core="io.reactivex.rxjava2:rxjava:$versions.rxJava"
    rxjava.rxKotlin = "io.reactivex.rxjava2:rxkotlin:$versions.rxKotlin"
    deps.rxjava = rxjava

    def kotlin = [:]
    kotlin.kotlin_jre = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$versions.kotlin"
    kotlin.stdlib= "org.jetbrains.kotlin:kotlin-stdlib:$versions.kotlin"
    kotlin.serialization ="org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$versions.serialization"
    kotlin.serialization_runtime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:$versions.serialization"
    kotlin.kissme= "com.netguru.kissme:kissme-common:0.2.3"
    deps.kotlin = kotlin

    def arrow = [:]
    arrow.core = "io.arrow-kt:arrow-core:$versions.arrow"
    deps.arrow= arrow


    def koin = [:]
    koin.core = "org.koin:koin-core:$versions.koin"
    koin.ext = "org.koin:koin-core-ext:$versions.koin"
    koin.test = "org.koin:koin-test:$versions.koin"
    deps.koin = koin

    def kotlinTest = [:]
    kotlinTest.junit = "org.junit.jupiter:junit-jupiter-api:$versions.junit"
    kotlinTest.kotlin_junit = "org.jetbrains.kotlin:kotlin-test-junit:$versions.kotlin"
    kotlinTest.mockk = "io.mockk:mockk:1.8.9.kotlin13"
    deps.kotlinTest = kotlinTest




    // Ktor dependencies
    def ktorDeps = [:]
    ktorDeps.nettyServer=  "io.ktor:ktor-server-netty:$versions.ktor_version"
    ktorDeps.logback= "ch.qos.logback:logback-classic:$versions.logback_version"
    ktorDeps.core = "io.ktor:ktor-server-core:$versions.ktor_version"
    ktorDeps.cioServer =  "io.ktor:ktor-server-cio:$versions.ktor_version"
    ktorDeps.htmlBuilder = "io.ktor:ktor-html-builder:$versions.ktor_version"
    ktorDeps.jackson =  "io.ktor:ktor-jackson:$versions.ktor_version"
    ktorDeps.auth =  "io.ktor:ktor-auth:$versions.ktor_version"
    ktorDeps.auth_jwt =  "io.ktor:ktor-auth-jwt:$versions.ktor_version"
    ktorDeps.gson =  "io.ktor:ktor-gson:$versions.ktor_version"
    ktorDeps.serverTest=  "io.ktor:ktor-server-tests:$versions.ktor_version"
    ktorDeps.koin= "org.koin:koin-ktor:$versions.koin"
    ktorDeps.exposed = "org.jetbrains.exposed:exposed:$versions.exposed"
    ktorDeps.hickariCp= "com.zaxxer:HikariCP:$versions.hickariCp"
    ktorDeps.h2 = "com.h2database:h2:$versions.h2"
    deps.ktorDeps = ktorDeps


    //Ktor Client
    def ktorClient = [:]
    ktorClient.commonCore = "io.ktor:ktor-client-core:$versions.ktor_version"
    ktorClient.jvmCore = "io.ktor:ktor-client-core-jvm:$versions.ktor_version"
    ktorClient.iosCore = "io.ktor:ktor-client-ios:$versions.ktor-version"
    ktorClient.commenJson="io.ktor:ktor-client-json:$versions.ktor_version"
    ktorClient.jvmJso="io.ktor:ktor-client-json-jvm:$versions.ktor_version"
    ktorClient.iosJson = "io.ktor:ktor-client-json-native:$versions.ktor_version"
    ktorClient.iosNative = "io.ktor:ktor-client-core-native:$versions.ktor_version"
    deps.ktorClient = ktorClient
    def serialization = [:]
    serialization.common = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$versions.serialization"
    serialization.jvm= "org.jetbrains.kotlinx:kotlinx-serialization-runtime:$versions.serialization"
    serialization.ios = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$versions.serialization"
    deps.serialization = serialization





    // Android dependecies !!
    def android = [:]

    android.appcompat = "androidx.appcompat:appcompat:$versions.appcompat"
    android.fragment = "androidx.fragment:fragment:$versions.appcompat"
    android.recyclerview = "androidx.recyclerview:recyclerview:$versions.appcompat"
    android.design = "com.google.android.material:material:$versions.design"
    android.constraint_layout = "androidx.constraintlayout:constraintlayout:$versions.constraint_layout"
    android.lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:$versions.lifecycle"
    android.ktx_fragment = "androidx.fragment:fragment-ktx:$versions.ktx_fragment"
    android.rxAndroid= "io.reactivex.rxjava2:rxandroid:$versions.rxAndroid"
    deps.android = android

    def room = [:]
    room.runtime = "androidx.room:room-runtime:$versions.room"
    room.compiler = "androidx.room:room-compiler:$versions.room"
    deps.room = room

    def dagger=[:]
    dagger.core= "com.google.dagger:dagger-android:$versions.dagger"
    dagger.support= "com.google.dagger:dagger-android-support:$versions.dagger"
    dagger.kaptCompiler= "com.google.dagger:dagger-compiler:$versions.dagger"
    dagger.kaptProcessor= "com.google.dagger:dagger-android-processor:$versions.dagger"
    deps.dagger=dagger

}