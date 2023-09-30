plugins {
   id("com.android.application")
   id("org.jetbrains.kotlin.android")
   id("com.google.dagger.hilt.android")
   id("com.google.devtools.ksp")
   kotlin("kapt")
}

android {
   namespace = "de.rogallab.mobile"
   compileSdk = 34

   defaultConfig {
      applicationId = "de.rogallab.mobile"
      minSdk = 26
      targetSdk = 34
      versionCode = 1
      versionName = "1.0"

      javaCompileOptions {
         annotationProcessorOptions {
            arguments += mapOf(
               "room.schemaLocation" to "$projectDir/schemas",
               "room.incremental" to "true"
            )
         }
      }

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
   }

   buildTypes {
      release {
         isMinifyEnabled = false
         proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      }
   }
   buildFeatures {
      dataBinding = true
   }
   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_17
      targetCompatibility = JavaVersion.VERSION_17
   }
   kotlinOptions {
      jvmTarget = "17"
   }
   kotlin {
      jvmToolchain(17)
   }
}

dependencies {
   // https://developer.android.com/jetpack/androidx/releases/activity
   val activity_version = "1.7.2"
   // https://developer.android.com/jetpack/androidx/releases/appcompat
   val appcompatVersion = "1.6.1"
   // https://developer.android.com/jetpack/androidx/releases/constraintlayout
   val constraintlayoutVersion = "2.1.4"
   // https://developer.android.com/jetpack/androidx/releases/core
   val coreVersion = "1.12.0"

   // Kotlin
   implementation("androidx.activity:activity-ktx:$activity_version")
   implementation("androidx.appcompat:appcompat:$appcompatVersion")
   implementation("androidx.constraintlayout:constraintlayout:$constraintlayoutVersion")
   implementation("androidx.core:core-ktx:$coreVersion")

   // https://developer.android.com/jetpack/androidx/releases/databinding
   // not necessary, bundled with android Gradle plugin
   // val dataBindingVersion = "3.5.0"
   // implementation("androidx.databinding:databinding-runtime:")


   // https://material.io/blog/android-stable-release-1-8-0
   val materialVersion = "1.9.0"
   implementation("com.google.android.material:material:$materialVersion")

   // ViewModel, LiveData
   // https://developer.android.com/jetpack/androidx/releases/lifecycle
   val lifecycleVersion = "2.6.2"
   val archVersion = "2.2.0"
   implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
   implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
   // Annotation processor
   annotationProcessor("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")

   // Coroutines, Flow
   val coroutinesVersion = "1.7.3"
   implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
   implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")


   // Room Database
   // https://developer.android.com/jetpack/androidx/releases/room
   val roomVersion = "2.5.2"
   val roomTesting = "2.5.2"
   implementation("androidx.room:room-runtime:$roomVersion")
   implementation("androidx.room:room-ktx:$roomVersion")
// kapt("androidx.room:room-compiler:$roomVersion")
   ksp("androidx.room:room-compiler:$roomVersion")

   // Dagger, Hilt
   // https://developer.android.com/training/dependency-injection/hilt-android
   // https://dagger.dev/hilt/
   val hiltAndroidVersion = "2.48"
   implementation ("com.google.dagger:hilt-android:$hiltAndroidVersion")
   ksp("com.google.dagger:hilt-compiler:$hiltAndroidVersion")


   testImplementation("junit:junit:4.13.2")
   androidTestImplementation("androidx.test.ext:junit:1.1.5")
   androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

kapt {
   correctErrorTypes = true
}