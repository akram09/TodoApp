buildscript {
    repositories {
        addRepos()
    }

    dependencies {
        classpath( ClassPaths.Serialization)
        classpath(ClassPaths.KotlinGradlePlugin)
        classpath(ClassPaths.AndroidGradlePlugin)
    }
}

allprojects {
    repositories {
       addRepos()
    }
}