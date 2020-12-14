<p align="center">
  <a href="https://github.com/cioccarellia/kite" target="_blank"><img width="100" src="art/icon_dark.png"></a>
</p>
<h1 align="center">Kite</h1>
<p align="center">Android Resource Wrapper Library.</p>
<p align="center">
  <a href="https://bintray.com/cioccarellia/maven/kite/_latestVersion"><img src="https://api.bintray.com/packages/cioccarellia/maven/kite/images/download.svg" alt="Download from Bintray"></a>
  <a href="https://android-arsenal.com/details/1/8194"><img src="https://img.shields.io/badge/Android%20Arsenal-kite-brightgreen.svg?style=flat" alt="Android Arsenal"></a>
  <a href="https://github.com/cioccarellia/kite/actions?query=workflow%3A%22Android+CI%22"><img src="https://github.com/cioccarellia/kite/workflows/Android%20CI/badge.svg" alt="Bintray Github Action" /></a>
  <a href="https://github.com/cioccarellia/kite/actions?query=workflow%3A%22Bintray+Release%22"><img src="https://github.com/cioccarellia/kite/workflows/Bintray%20Release/badge.svg" alt="Bintray Github Action" /></a>
  <a href="https://app.circleci.com/pipelines/github/cioccarellia/kite"><img src="https://circleci.com/gh/cioccarellia/kite.svg?style=svg" alt="CircleCI"></a>
  <a href="https://www.codacy.com/gh/cioccarellia/kite/dashboard"><img src="https://app.codacy.com/project/badge/Grade/91fb67a5494d4767b71c7bf99810c1c9" alt="Codacy"></a>
  <a href="https://kotlinlang.org/releases.html"><img src="https://img.shields.io/badge/kotlin-1.4.21-orange.svg" alt="Kotlin"></a>
  <a><img src="https://img.shields.io/badge/min-14-00e676.svg" alt="Android Min Sdk"></a>
  <a><img src="https://img.shields.io/badge/compile-30-00e676.svg" alt="Android Compile Version"></a>
  <a href="https://github.com/cioccarellia/kite/blob/master/LICENSE"><img src="https://img.shields.io/badge/license-Apache%202.0-blue.svg" alt="License"></a>
</p>

## TLDR
Fed up with typing `ContextCompact`, `resources` and `context` all over your apps to access your resources? Say no more.
```gradle
implementation 'com.cioccarellia:kite:1.1.1'
```

- :kite: Access all app resources with one unified syntax.
- :dna: Null safe layer between the Android framework java code and your app.
- :ice_cube: Transparent and lightweight wrapper.
- :lock: Extensive built-in checks.
- :zap: Easy to implement in existing apps.
- :heart: Kotlin powered, 100%.


```kotlin
val text = Kite.string[R.string.welcome_back]
```

## Usage
Kite is a handy and lightweight android library which aims at reducing redundancy and decreasing android code complexity.
It encloses and simplifies resource access within the Kite domain, and abstracts away the implementation logic needed to fetch the desired value, making interactions with the android framework smooth and frictionless.
To get started initialize kite (ideally inside your `Application` class) and pass to it the application context.

```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Kite.fly(this)
    }
}
```

You're all set. You can now import the `Kite` object, select whichever resource category you want to access and fetch it using the resource id and the bracket notation `[]`.

Beware: kite can not and **will not** save you from the mess that is dealing with Android `Context`.
After all, kite is some cleverly placed syntactic sugar over those same android methods you are used to: kite itself holds a reference to `Context`.
It will, however, unify and thoroughly uniform your experience with dealing with all android related resource extraction operations, which can turn to be extremely practical.
It may also save you from typing again `ContextCompact` in your life. That's the precise reason kite was created. I'm not kidding.


## Samples
```kotlin
// 🪁 Kite
fab.rippleColor =         Kite.color[R.color.md_light_lime]
fab.backgroundTintList =  Kite.colorStateList[R.color.md_lime]
fab.text =                Kite.string[R.string.unread_notifications, "69"]
fab.isVisible =           Kite.bools[R.bool.show_fab]

// Standard
fab.rippleColor =         ContextCompact.getColor(context, R.color.md_light_lime)
fab.backgroundTintList =  ColorStateList.valueOf(R.color.md_lime)
fab.text =                appContext.getString(R.string.unread_notifications, "69")
fab.isVisible =           resources.getBoolean(R.bool.show_fab)
```

## Context Switching
One clear disadvantage to using kite with respect to doing things the old way is choosing which context to use.
That's why Kite comes packed with extension functions for permanent change / temporary switch the in-use context, so that you have full control over which context is used to do what.
- `changeContext` can be invoked on `Kite` and on any `KiteFetcher`, it is chainable and it permanently changes the context reference kite holds.
```kotlin
Kite.changeContext(this)
Kite.integer.changeContext(this)[R.integer.threads]
```

- `runWith` can be invoked on any `KiteFetcher`, it is chainable and it temporarily runs the passed lambda in the desired context.
```kotlin
Kite.color.runWith(this) { color ->
    button.setBackground(
        color[R.color.colorAccent]
    )
}
```

## Supported Resources
Kite delegates resource collection to `KiteFetcher`s. Those classes contain a well defined implementation of the actual process of converting the given `id` to the output type.

| Resource Type   	| AAPT class       	| Fetcher                	| Input                                                   	| Output              	| Implementation                      	| API 	| Variants           	|
|-----------------	|------------------	|-----------------------	|---------------------------------------------------------	|---------------------	|-------------------------------------	|-----	|--------------------	|
| Strings         	| `R.string`       	| `Kite.string`         	| `@StringRes string: Int`                                	| `String`            	| `Context.getString()`               	| /   	| `formatArgs`       	|
| Plurals         	| `R.plurals`      	| `Kite.plural`         	| `@PluralRes plural: Int`, `quantity: Int`               	| `String`            	| `Resources.getQuantityString()`     	| /   	| `formatArgs`       	|
| Texts           	| `R.string`       	| `Kite.text`           	| `@StringRes text: Int`                                  	| `CharSequence`      	| `Context.getText()`                 	| /   	| /                  	|
| Color           	| `R.color`        	| `Kite.color`          	| `@ColorRes color: Int`                                  	| `@ColorInt Color`   	| `ContextCompat.getColor()`          	| /   	| /                  	|
| ColorStateLists 	| `R.color`        	| `Kite.colorStateList` 	| `@ColorRes colorStateList: Int`                         	| `ColorStateList`    	| `ContextCompat.getColorStateList()` 	| /   	| /                  	|
| Drawables       	| `R.drawable`     	| `Kite.drawable`       	| `@DrawableRes drawable: Int`                            	| `Drawable`          	| `ContextCompat.getDrawable()`       	| /   	| `Resources.Theme?` 	|
| Layouts         	| `R.layout`       	| `Kite.layout`         	| `@LayoutRes layout: Int`                                	| `XmlResourceParser` 	| `Resources.getLayout()`             	| /   	| /                  	|
| Integer         	| `R.integer`      	| `Kite.integer`        	| `@IntegerRes integer: Int`                              	| `Int`               	| `Resources.getInteger()`            	| /   	| /                  	|
| Booleans        	| `R.bool`         	| `Kite.booleans`       	| `@BoolRes boolean: Int`                                  	| `Boolean`           	| `Resources.getBoolean()`            	| /   	| /                  	|
| Dimensions      	| `R.dimen`        	| `Kite.dimension`      	| `@DimenRes dimensions: Int`                             	| `Float`             	| `Resources.getDimensions()`         	| /   	| /                  	|
| Fractions       	| `R.fraction`     	| `Kite.fraction`       	| `@FractionRes fraction: Int`, `base: Int`, `pbase: Int` 	| `Float`             	| `Resources.getFraction()`           	| /   	| /                  	|
| Fonts           	| `R.font`         	| `Kite.font`           	| `@FontRes font: Int`                                    	| `Typeface`          	| `Resources.getFont()`               	| 26  	| /                  	|
| Animations      	| `R.anim`         	| `Kite.animation`      	| `@AnimRes animation: Int`                               	| `Animation`         	| `AnimationUtils.loadAnimation()`    	| /   	| /                  	|
| Interpolators   	| `R.interpolator` 	| `Kite.interpolation`  	| `@InterpolatorRes interpolator: Int`                    	| `Interpolator`      	| `AnimationUtils.loadInterpolator()` 	| /   	| /                  	|
| IntArray        	| `R.array`        	| `Kite.intArray`       	| `@ArrayRes intArray: Int`                               	| `IntArray`          	| `Resources.getIntArray()`           	| /   	| /                  	|
| StringArray     	| `R.array`        	| `Kite.stringArray`    	| `@ArrayRes stringArray: Int`                            	| `Array<out String>` 	| `Resources.getStringArray()`        	| /   	| /                  	|
| TypedArray     	| `R.array`        	| `Kite.typedArray`     	| `@ArrayRes typedArray: Int`                             	| `TypedArray`        	| `Resources.obtainTypedArray()`      	| /   	| /                  	|
| Identifiers     	| `R.id`           	| `Kite.identifier`     	| `name: String`, `defType: String`, `defPackage: String` 	| `Int`               	| `Resources.getIdentifier()`         	| /   	| /                  	|
| Xmls            	| `R.xml`          	| `Kite.xml`            	| `@XmlRes xml: Int`                                      	| `XmlResourceParser` 	| `Resources.getXml()`                	| /   	| /                  	|
| Raws            	| `R.raw`          	| `Kite.raw`            	| `@RawRes raw: Int`                                      	| `InputStream`       	| `Resources.openRawResource()`       	| /   	| `TypedValue`       	|

## :warning: Known Issues
- Annotation checks over resource parameters (functions which take as argument some annotated value, like `@ColorRes`, `@StringRes`) are not extensively performed by Android Studio, when using kotlin operator functions: I created a bug report at google issue tracker [here](https://issuetracker.google.com/issues/173628041). Hope to see it fixed soon.

## Kite Puns
- A kite usually comes with different *colors*
- A kite is flown and controlled with *strings*
