package util

import org.gradle.api.Project
import java.util.*

private const val LOCAL_PROPERTIES_FILE_NAME = "local.properties"
private const val KEYSTORE_PROPERTIES_FILE_NAME = "keystore/keystore.properties"

fun getLocalProperty(propertyName: String, project: Project): String {
  return getProperty(LOCAL_PROPERTIES_FILE_NAME, propertyName, project)
}

fun getKeystoreProperty(propertyName: String, project: Project): String {
  return getProperty(KEYSTORE_PROPERTIES_FILE_NAME, propertyName, project)
}

private fun getProperty(propertyFileName: String, propertyName: String, project: Project): String {
  val localProperties = Properties().apply {
    val localPropertiesFile = project.rootProject.file(propertyFileName)
    if (localPropertiesFile.exists()) {
      load(localPropertiesFile.inputStream())
    }
  }

  return localProperties.getProperty(propertyName)?.let {
    it
  } ?: run {
    throw NoSuchFieldException("Not defined property: $propertyName")
  }
}
