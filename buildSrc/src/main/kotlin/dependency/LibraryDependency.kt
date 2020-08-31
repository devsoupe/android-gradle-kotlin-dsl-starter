package dependency

object LibraryDependency {
  const val KOTLIN = "${LibraryId.KOTLIN}:${LibraryVersion.KOTLIN}"
  const val CORE_KTX = "${LibraryId.CORE_KTX}:${LibraryVersion.CORE_KTX}"
  const val APP_COMPAT = "${LibraryId.APP_COMPAT}:${LibraryVersion.APP_COMPAT}"
  const val CONSTRAINT_LAYOUT = "${LibraryId.CONSTRAINT_LAYOUT}:${LibraryVersion.CONSTRAINT_LAYOUT}"
}

private object LibraryId {
  const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib"
  const val CORE_KTX = "androidx.core:core-ktx"
  const val APP_COMPAT = "androidx.appcompat:appcompat"
  const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout"
}

private object LibraryVersion {
  const val KOTLIN = "1.3.72"
  const val CORE_KTX = "1.3.1"
  const val APP_COMPAT = "1.2.0"
  const val CONSTRAINT_LAYOUT = "2.0.0"
}
