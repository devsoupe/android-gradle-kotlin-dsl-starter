plugins {
  id(BuildPluginId.KTLINT) version BuildPluginVersion.KTLINT
}

allprojects {

  repositories {
    google()
    jcenter()
    mavenCentral()
  }

  plugins.apply(BuildPluginId.KTLINT)
  plugins.apply(BuildPluginId.DETEKT)
  plugins.apply(BuildPluginId.GIT_HOOKS)

  ktlint {
    debug.set(false)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    ignoreFailures.set(false)
    enableExperimentalRules.set(true)

    filter {
      exclude("**/generated/**")
      include("**/kotlin/**")
    }
  }
}

tasks.register("clean", Delete::class.java) {
  delete(rootProject.buildDir)
}
