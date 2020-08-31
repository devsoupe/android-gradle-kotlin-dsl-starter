package dependency

object TestLibraryDependency {
  const val JUNIT = "${TestLibraryId.JUNIT}:${TestLibraryVersion.JUNIT}"
  const val EXT_JUNIT = "${TestLibraryId.EXT_JUNIT}:${TestLibraryVersion.EXT_JUNIT}"
  const val ESPRESSO = "${TestLibraryId.ESPRESSO}:${TestLibraryVersion.ESPRESSO}"
}

private object TestLibraryId {
  const val JUNIT = "junit:junit"
  const val EXT_JUNIT = "androidx.test.ext:junit"
  const val ESPRESSO = "androidx.test.espresso:espresso-core"
}

private object TestLibraryVersion {
  const val JUNIT = "4.13"
  const val EXT_JUNIT = "1.1.1"
  const val ESPRESSO = "3.2.0"
}
