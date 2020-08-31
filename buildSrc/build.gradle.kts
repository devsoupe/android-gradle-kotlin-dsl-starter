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
}

object BuildPluginVersion {
  const val GRADLE_ANDROID = "4.0.1"
  const val DETEKT = "1.10.0"
}

dependencies {
  implementation("${BuildPluginId.GRADLE_ANDROID}:${BuildPluginVersion.GRADLE_ANDROID}")
  implementation("${BuildPluginId.DETEKT}:${BuildPluginVersion.DETEKT}")
}
