package util

import org.apache.commons.configuration2.PropertiesConfiguration
import org.apache.commons.configuration2.PropertiesConfigurationLayout
import org.gradle.api.Project
import java.io.InputStreamReader
import java.util.*


private const val LOCAL_PROPERTIES_FILE_NAME = "local.properties"
private const val KEYSTORE_PROPERTIES_FILE_NAME = "keystore/keystore.properties"
private const val VERSION_PROPERTIES_FILE_NAME = "version/version.properties"

fun getLocalProperty(propertyName: String, project: Project): String {
  return getProperty(LOCAL_PROPERTIES_FILE_NAME, propertyName, project)
}

fun getKeystoreProperty(propertyName: String, project: Project): String {
  return getProperty(KEYSTORE_PROPERTIES_FILE_NAME, propertyName, project)
}

fun setVersionProperty(propertyName: String, value: String, project: Project) {
  return setProperty(VERSION_PROPERTIES_FILE_NAME, propertyName, value, project)
}

fun getVersionProperty(propertyName: String, project: Project): String {
  return getProperty(VERSION_PROPERTIES_FILE_NAME, propertyName, project)
}

private fun setProperty(propertyFileName: String, propertyName: String, value: String, project: Project) {
  val localPropertiesFile = project.rootProject.file(propertyFileName)
  if (localPropertiesFile.exists()) {
    val config = PropertiesConfiguration()
    val layout = PropertiesConfigurationLayout()

    layout.load(config, InputStreamReader(localPropertiesFile.inputStream()))

    config.setProperty(propertyName, value)
    layout.save(config, localPropertiesFile.writer())
  }
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
