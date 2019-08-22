buildscript {
    repositories {
        addRepos()
    }

    dependencies {
        classpath( ClassPaths.Serialization)
        classpath(ClassPaths.KotlinGradlePlugin)
        classpath(ClassPaths.xcodePlugin)
        classpath(ClassPaths.shadowPlugin)
        classpath(ClassPaths.AndroidGradlePlugin)
    }
}

allprojects {
    repositories {
       addRepos()
    }
}