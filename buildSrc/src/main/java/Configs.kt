import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.maven

object Configs {
    object BuildVersion {
        const val min_sdk = 21
        const val target_sdk = 28
    }
}
fun RepositoryHandler.addRepos() {
    google()
    jcenter()
    mavenLocal()
    mavenCentral()
    maven(url = "https://jitpack.io" )
    maven(url = "https://kotlin.bintray.com/ktor" )
    maven(url ="https://dl.bintray.com/netguru/maven/" )
    maven( url ="https://dl.bintray.com/kotlin/kotlinx" )
    maven(url = "https://dl.bintray.com/arrow-kt/arrow-kt/" )
    maven(url = "https://kotlin.bintray.com/kotlin-js-wrappers")
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots" )
    maven (url = "https://dl.bintray.com/kotlin/kotlin-eap" )
}