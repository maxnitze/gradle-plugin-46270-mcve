# MCVE 46270

<https://discuss.gradle.org/t/add-configuration-when-plugin-is-applied-handling-different-plugin-versions/46270>

## Prep

* publish plugin to maven local
  ```bash
  ./gradlew :plugin:publishToMavenLocal
  ```

## Test

### Successful, when Axion Release Plugin is applied

* run subproject `usage` as is
  ```bash
  ./gradlew :usage:properties
  ```
  * this will print the properties including the version, that is set to `0.1.0-<GIT_HASH>-SNAPSHOT`

### Failure, when Axion Release Plugin is not applied

* comment/remove line with `id("pl.allegro.tech.build.axion-release")` in `usage/build.gradle.kts`
* run subproject `usage`
  ```bash
  ./gradlew :usage:properties
  ```
  * this will fail with _ClassDef not found_
