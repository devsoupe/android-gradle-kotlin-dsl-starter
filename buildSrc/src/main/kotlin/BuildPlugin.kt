object BuildPluginClassPath {
  const val GRADLE_ANDROID = "com.android.tools.build:gradle"
}

object BuildPluginId {
  const val ANDROID_APPLICATION = "com.android.application"
  const val ANDROID_LIBRARY = "com.android.library"
  const val ANDROID_KOTLIN = "org.jetbrains.kotlin.android"
  const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
  const val KTLINT = "org.jlleitschuh.gradle.ktlint"

  const val JAVA_LIBRARY = "java-library"
  const val KOTLIN_ANDROID = "kotlin-android"
  const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
  const val KOTLIN_KAPT = "kotlin-kapt"

  const val DETEKT = "plugin.detekt"
  const val GIT_HOOKS = "plugin.git-hooks"
}

object BuildPluginVersion {
  const val GRADLE_ANDROID = "4.0.1"
  const val KOTLIN = "1.4.0"
  const val KTLINT = "9.3.0"
}
