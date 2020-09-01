plugins {
  `java-gradle-plugin`
  `kotlin-dsl`
  `kotlin-dsl-precompiled-script-plugins`
}

repositories {
  google()
  jcenter()
  mavenCentral()
  maven("https://plugins.gradle.org/m2/")
}

object BuildPluginId {
  const val GRADLE_ANDROID = "com.android.tools.build:gradle"
  const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin"
  const val SEMVER = "com.github.glwithu06.semver:semver"
  const val APACHE_COMMON_CONFIGURATION = "org.apache.commons:commons-configuration2"
}

object BuildPluginVersion {
  const val GRADLE_ANDROID = "4.0.1"
  const val DETEKT = "1.10.0"
  const val SEMVER = "1.0.1"
  const val APACHE_COMMON_CONFIGURATION = "2.7"
}

dependencies {
  implementation("${BuildPluginId.GRADLE_ANDROID}:${BuildPluginVersion.GRADLE_ANDROID}")
  implementation("${BuildPluginId.DETEKT}:${BuildPluginVersion.DETEKT}")
  implementation("${BuildPluginId.SEMVER}:${BuildPluginVersion.SEMVER}")
  implementation(
    "${BuildPluginId.APACHE_COMMON_CONFIGURATION}:${BuildPluginVersion.APACHE_COMMON_CONFIGURATION}"
  )
}
