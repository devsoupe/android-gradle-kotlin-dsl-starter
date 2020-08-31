package util

import java.util.*

fun isLinuxOrMacOs(): Boolean {
  val osName = System.getProperty("os.name").toLowerCase(Locale.ROOT)
  return listOf("linux", "mac os", "macos").contains(osName)
}
