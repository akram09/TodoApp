import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}

group ="com.kero.akram.todo"
version ="0.0.1"
// mainClassName = "io.ktor.server.netty.ApplicationKt"



tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.withType<Test> {
    useJUnitPlatform {}
}
repositories{
    addRepos()
}
dependencies {
    implementation(Dependencies.Kotlin.Jre)
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Koin.Core)
    implementation(Dependencies.Koin.Extensions)
    implementation(Dependencies.Koin.Ktor)
    implementation(Dependencies.Exposed)
    implementation(Dependencies.HickariCp)
    implementation(Dependencies.H2Db)
//    implementation deps.arrow.core
    implementation(Dependencies.Ktor.Netty)
    implementation(Dependencies.Ktor.logback)
    implementation(Dependencies.Ktor.Core)
    implementation(Dependencies.Ktor.CioServer)
    implementation(Dependencies.Ktor.Jackson)
    implementation(Dependencies.Ktor.Auth)
    implementation(Dependencies.Ktor.AuthJwt)
    implementation (Dependencies.Ktor.Gson)

}
