package extension

import org.gradle.api.Project
import util.getKeystoreProperty
import util.getLocalProperty

fun Project.getLocalProperty(propertyName: String): String {
  return getLocalProperty(propertyName, this)
}

fun Project.getKeystoreProperty(propertyName: String): String {
  return getKeystoreProperty(propertyName, this)
}
