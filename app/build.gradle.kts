plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.github.ben-manes.versions")
}

android {
    compileSdk = ConfigData.compileSdkVersion
    buildToolsVersion = ConfigData.buildToolsVersion

    defaultConfig {
        applicationId = "bose.ankush.weatherify"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        multiDexEnabled = ConfigData.multiDexEnabled
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    api(project(":Utilities"))

    // Unit Testing
    testImplementation(Deps.junit)
    testImplementation(Deps.truth)
    testImplementation(Deps.turbine)
    testImplementation(Deps.coroutineTest)
    testImplementation(Deps.coreTesting)
    testImplementation(Deps.mockitoInline)
    testImplementation(Deps.mockitoNhaarman)
    testImplementation(Deps.mockWebServer)

    // UI Testing
    androidTestImplementation(Deps.extJunit)
    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(Deps.espressoContrib)
    androidTestImplementation(Deps.composeUiTest)

    // Compose
    implementation(Deps.composeUi)
    implementation(Deps.composeMaterial)
    debugImplementation(Deps.composeUiTooling)
    implementation(Deps.composeUiToolingPreview)

    // Core
    implementation(Deps.androidCore)
    implementation(Deps.appCompat)
    implementation(Deps.androidMaterial)
    implementation(Deps.viewModelCompose)
    implementation(Deps.navigationCompose)
    implementation(Deps.inAppUpdate)
    implementation(Deps.inAppUpdateKtx)
    implementation(Deps.animatedNavigation)

    // Networking
    implementation(Deps.okHttp3)
    implementation(Deps.retrofit)
    implementation(Deps.retrofitGson)
    implementation(Deps.okhttpInterceptor)

    // Coroutines
    implementation(Deps.retrofitCoroutineAdapter)
    implementation(Deps.coroutinesCore)
    implementation(Deps.coroutinesAndroid)

    // Dependency Injection
    implementation(Deps.hilt)
    kapt(Deps.hiltDaggerAndroidCompiler)
    kapt(Deps.hiltAndroidxCompiler)
    implementation(Deps.hiltNavigationCompose)

    // Miscellaneous
    implementation(Deps.timber)
    implementation(Deps.lottieCompose)
    implementation(Deps.coilCompose)

    // Memory leak
    debugImplementation(Deps.leakCanary)
}