# Android Gradle Kotlin DSL Starter (Kotlin DSL Template)

[![Use this template](https://img.shields.io/badge/from-android--gradle--kotlin--dsl--starter-purple?logo=dropbox)](https://github.com/perelandrax/android-gradle-kotlin-dsl-starter/generate)
![Language](https://img.shields.io/badge/kotlin-100.0%25-blue?logo=kotlin)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

<b>`Android Gradle Kotlin DSL Starter`</b> provides a simple template for those who want to start a project with the Kotlin DSL.

## Getting Started

Android Gradle Kotlin DSL Starter is a template that you can use when setting up your first android project. Also, this template is focused on delivering a project with static analysis and continuous integration already in place.

## Features

- **100% Kotlin-only template**.
- 100% Gradle Kotlin DSL setup.
- Dependency versions managed via `buildSrc`.
- Kotlin Static Analysis via `ktlint` and `detekt`.
- Git Setup with Git-Hooks.

## Installation

1. Create a new repo starting from this template using [![Use this template](https://img.shields.io/badge/-fork%20template-orange)](https://github.com/perelandrax/android-gradle-kotlin-dsl-starter/generate) button.
2. Update [APPLICATION_ID](buildSrc/src/main/kotlin/BuildAndroid.kt) and [BUILD_FILE_PREFIX](buildSrc/src/main/kotlin/BuildAndroid.kt) according to your project.
3. Update the [package](app/src/main/AndroidManifest.xml) name and [label](app/src/main/AndroidManifest.xml) of AndroidManifest to suit your project.
4. Update package of the all source files

## Environment setup

Some default settings are required to use the project.

### Keystore

  * Create keystore folder in project root.
  * Create keystore.properties and key files for debug and release in the created keystore folder.

  ```properties
  # Signing Config
  # release
  release.signing.key.alias=<insert>
  release.signing.key.password=<insert>
  release.signing.store.file=<insert> (../keystore/xxxxxxx.jks or .keystore)
  release.signing.store.password=<insert>
  # debug
  debug.signing.key.alias=<insert>
  debug.signing.key.password=<insert>
  debug.signing.store.file=<insert> (../keystore/xxxxxxx.jks or .keystore)
  debug.signing.store.password=<insert>
  ```

### Coding Standards

To maintain the style and quality of the code, are used the bellow static analysis tools. All of them use properly configuration and you find them in the project root directory `.{toolName}`.

| Tools                                                   | Config file                                                                       | Check command             | Fix command               |
|---------------------------------------------------------|----------------------------------------------------------------------------------:|---------------------------|---------------------------|
| [detekt](https://github.com/arturbosch/detekt)          | [/.detekt](https://github.com/VMadalin/kotlin-sample-app/tree/master/.detekt)     | `./gradlew detekt`        | -                         |
| [ktlint](https://github.com/pinterest/ktlint)           | -                                                                                 | `./gradlew ktlintCheck`        | `./gradlew ktlintFormat`  |
| [lint](https://developer.android.com/studio/write/lint) | [/.lint](https://github.com/VMadalin/kotlin-sample-app/tree/master/.lint)         | `./gradlew lint`          | -                         |

All of the above tests can be run with `./gradlew check`, which is used through Git-Hooks below. If you need to modify your coding standards, please refer to `.editorconfig`

### Git-Hooks

When the project build is complete, git hooks related copyGitHooks, deleteGitHooks, and installGitHooks tasks will be created. When you run the `installGitHooks` task, pre-push hooks are installed, and from then on, push is performed only if there is no problem by performing `./gradlew check` before being pushed to git.

## License

Android Gradle Kotlin DSL Starter is under MIT license. See the LICENSE for more info.