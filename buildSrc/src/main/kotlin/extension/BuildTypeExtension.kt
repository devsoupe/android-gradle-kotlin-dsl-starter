package extension

import com.android.build.gradle.internal.dsl.BuildType

fun BuildType.buildConfigStringField(name: String, value: String) {
  this.buildConfigField("String", name, "\"$value\"")
}

fun BuildType.buildConfigIntField(name: String, value: Int) {
  this.buildConfigField("int", name, value.toString())
}

fun BuildType.buildConfigBooleanField(name: String, value: Boolean) {
  this.buildConfigField("boolean", name, value.toString())
}
