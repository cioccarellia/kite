<p align="center">
  <a href="https://github.com/cioccarellia/kite" target="_blank"><img width="100" src="art/icon.png"></a>
</p>
<h1 align="center">Kite</h1>
<p align="center">Android Resource Converger Library.</p>
<p align="center">
  <a href="https://bintray.com/cioccarellia/maven/kite/_latestVersion"><img src="https://api.bintray.com/packages/cioccarellia/maven/kite/images/download.svg" alt="Download from Bintray"></a>
  <a href="https://app.circleci.com/pipelines/github/cioccarellia/kite"><img src="https://circleci.com/gh/cioccarellia/kite.svg?style=svg" alt="CircleCI"></a>
  <a href="https://app.codacy.com/manual/cioccarellia/kite/dashboard"><img src="https://app.codacy.com/project/badge/Grade/91fb67a5494d4767b71c7bf99810c1c9" alt="Codacy"></a>
  <a><img src="https://img.shields.io/badge/kotlin-1.4.10-orange.svg" alt="Kotlin"></a>
  <a><img src="https://img.shields.io/badge/min-14-00e676.svg" alt="Android Min Sdk"></a>
  <a><img src="https://img.shields.io/badge/compile-30-00e676.svg" alt="Android Compile Version"></a>
  <a href="https://github.com/cioccarellia/kite/blob/master/LICENSE"><img src="https://img.shields.io/badge/license-Apache%202.0-blue.svg" alt="License"></a>
</p>

## TLDR
Fed up with typing ContextCompact, recources and context all over your apps to access your resources? Say no more.
```gradle
implementation 'com.cioccarellia:kite:1.0.0-alpha2'
```

- :heart: Kotlin powered.

```kotlin
class App : Application() {

    companion object {
        lateinit var appContext: Context
        val kite by lazy { Kite.fly(appContext) }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}
```
