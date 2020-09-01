package extension

import org.gradle.api.Project
import util.getKeystoreProperty
import util.getLocalProperty
import util.getVersionProperty
import util.setVersionProperty

fun Project.getLocalProperty(propertyName: String): String {
  return getLocalProperty(propertyName, this)
}

fun Project.getKeystoreProperty(propertyName: String): String {
  return getKeystoreProperty(propertyName, this)
}

fun Project.setVersionProperty(propertyName: String, value: String) {
  return setVersionProperty(propertyName, value, this)
}

fun Project.getVersionProperty(propertyName: String): String {
  return getVersionProperty(propertyName, this)
}
