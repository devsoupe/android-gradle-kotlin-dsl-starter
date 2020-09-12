plugins {
  `java-gradle-plugin`
  `kotlin-dsl`
  `kotlin-dsl-precompiled-script-plugins`
}

repositories {
  google()
  jcenter()
}

object BuildSrcId {
  const val GRADLE_ANDROID = "com.android.tools.build:gradle"
  const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin"
  const val SEMVER = "com.github.glwithu06.semver:semver"
  const val APACHE_COMMON_CONFIGURATION = "org.apache.commons:commons-configuration2"
}

object BuildSrcVersion {
  const val GRADLE_ANDROID = "4.0.1"
  const val DETEKT = "1.10.0"
  const val SEMVER = "1.0.1"
  const val APACHE_COMMON_CONFIGURATION = "2.7"
}

dependencies {
  implementation("${BuildSrcId.GRADLE_ANDROID}:${BuildSrcVersion.GRADLE_ANDROID}")
  implementation("${BuildSrcId.DETEKT}:${BuildSrcVersion.DETEKT}")
  implementation("${BuildSrcId.SEMVER}:${BuildSrcVersion.SEMVER}")
  implementation(
    "${BuildSrcId.APACHE_COMMON_CONFIGURATION}:${BuildSrcVersion.APACHE_COMMON_CONFIGURATION}"
  )
}
