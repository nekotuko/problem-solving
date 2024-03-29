/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/8.0.2/userguide/multi_project_builds.html
 */

rootProject.name = "problem-solving"

rootProject.projectDir
    .listFiles { file ->
        file.isDirectory && file.name.matches("^[a-z]{2}-[0-9]{4}(?:-[a-z0-9]+)+$".toRegex())
    }
    ?.forEach { file -> include(file.name) }

dependencyResolutionManagement {
    repositories { mavenCentral() }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
}
