import extension.buildConfigBooleanField
import extension.getKeystoreProperty

plugins {
  id(BuildPluginId.ANDROID_APPLICATION)
  id(BuildPluginId.KOTLIN_ANDROID)
  id(BuildPluginId.KOTLIN_ANDROID_EXTENSIONS)
  id(BuildPluginId.KOTLIN_KAPT)
}

android {
  compileSdkVersion(BuildAndroid.COMPILE_SDK_VERSION)

  defaultConfig {
    minSdkVersion(BuildAndroid.MIN_SDK_VERSION)
    targetSdkVersion(BuildAndroid.TARGET_SDK_VERSION)
    buildToolsVersion(BuildAndroid.BUILD_TOOLS_VERSION)

    applicationId = BuildAndroid.APPLICATION_ID
    versionCode = BuildAndroid.VERSION_CODE
    versionName = BuildAndroid.VERSION_NAME

    testInstrumentationRunner = BuildAndroid.TEST_INSTRUMENTATION_RUNNER
  }

  signingConfigs {

    create(BuildType.RELEASE) {
      keyAlias = getKeystoreProperty("release.signing.key.alias")
      keyPassword = getKeystoreProperty("release.signing.key.password")
      storeFile = file(getKeystoreProperty("release.signing.store.file"))
      storePassword = getKeystoreProperty("release.signing.store.password")
    }

    named(BuildType.DEBUG) {
      keyAlias = getKeystoreProperty("debug.signing.key.alias")
      keyPassword = getKeystoreProperty("debug.signing.key.password")
      storeFile = file(getKeystoreProperty("debug.signing.store.file"))
      storePassword = getKeystoreProperty("debug.signing.store.password")
    }
  }

  buildTypes {

    getByName(BuildType.RELEASE) {
      proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
      signingConfig = signingConfigs.getByName(name)

      isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
      isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled

      buildConfigBooleanField("ENABLE_CRASHLYTICS", BuildTypeRelease.isCrashlyticsEnabled)
    }

    getByName(BuildType.DEBUG) {
      applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
      versionNameSuffix = BuildTypeDebug.versionNameSuffix

      isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
      isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled

      buildConfigBooleanField("ENABLE_CRASHLYTICS", BuildTypeDebug.isCrashlyticsEnabled)
    }
  }

  flavorDimensions(BuildProductDimension.ENVIRONMENT)
  productFlavors {
    ProductFlavorDevelop.create(this)
    ProductFlavorQA.create(this)
    ProductFlavorProduction.create(this)
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_1_8.toString()
  }

  lintOptions {
    lintConfig = rootProject.file(".lint/config.xml")
    isCheckAllWarnings = true
    isWarningsAsErrors = true
  }

  testOptions {
    unitTests.isIncludeAndroidResources = true
    unitTests.isReturnDefaultValues = true
  }

  sourceSets {

    getByName("main") {
      java.srcDir("src/main/kotlin")
    }

    getByName("test") {
      java.srcDir("src/test/kotlin")
    }

    getByName("androidTest") {
      java.srcDir("src/androidTest/kotlin")
    }
  }
}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

  implementation(dependency.LibraryDependency.KOTLIN)
  implementation(dependency.LibraryDependency.CORE_KTX)
  implementation(dependency.LibraryDependency.APP_COMPAT)
  implementation(dependency.LibraryDependency.CONSTRAINT_LAYOUT)

  testImplementation(dependency.TestLibraryDependency.JUNIT)
  androidTestImplementation(dependency.TestLibraryDependency.EXT_JUNIT)
  androidTestImplementation(dependency.TestLibraryDependency.ESPRESSO)
}
