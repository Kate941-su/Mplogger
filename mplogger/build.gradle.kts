import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "io.github.kate941-su"
version = "1.0.2"

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "com.kaitokitaya.mplogger"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

//For publishing
mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), "mplogger", version.toString())

    pom {
        name = "Mplogger"
        description = "A mplogger for logging in Kotlin Multiplatfrom."
        inceptionYear = "2024"
        url = "https://github.com/Kate941-su/mplogger"
        licenses {
            license {
                name = "MIT License"
                url = "https://opensource.org/licenses/MIT"
                distribution = "https://opensource.org/licenses/MIT"
            }
        }
        developers {
            developer {
                id = "Kate941-su"
                name = "Kaito Kitaya"
                url = "https://github.com/Kate941-su"
            }
        }
        scm {
            url = "https://github.com/Kate941-su/mplogger"
            connection = "scm:git:git://github.com:Kate941-su/mplogger.git"
            developerConnection = "scm:git:ssh://git@github.com:Kate941-su/mplogger.git"
        }
    }
}


//For testing
//publishing {
//    repositories {
//        maven{
//            url = uri("${rootProject.layout.buildDirectory}/repo")
//        }
//    }
//}