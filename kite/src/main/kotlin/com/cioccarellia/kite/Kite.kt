/**
 * Designed and developed by Andrea Cioccarelli (@cioccarellia)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cioccarellia.kite

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.content.res.XmlResourceParser
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.animation.Animation
import android.view.animation.Interpolator
import com.cioccarellia.kite.fetchers.CustomKiteFetcher
import com.cioccarellia.kite.fetchers.StandardKiteFetcher
import com.cioccarellia.kite.fetchers.compat.KiteColorStateLists
import com.cioccarellia.kite.fetchers.compat.KiteColors
import com.cioccarellia.kite.fetchers.compat.KiteDrawables
import com.cioccarellia.kite.fetchers.context.KiteStrings
import com.cioccarellia.kite.fetchers.context.KiteTexts
import com.cioccarellia.kite.fetchers.custom.KiteAnimations
import com.cioccarellia.kite.fetchers.custom.KiteInterpolators
import com.cioccarellia.kite.fetchers.resources.*
import java.io.InputStream

public object Kite {
    /**
     * Initializes Kite and sets the current Kite [Context]
     *
     * @param context The [Context] kite is initialized with
     * */
    public fun fly(context: Context) {
        this.context = context
    }

    /**
     * [Context] used by default to fetch resources
     * */
    @PublishedApi
    internal lateinit var context: Context

    /**
     * Used to switch kite [Context].
     *
     * @param updatedContext    The [Context] to be set as the new kite [context]
     * @return [Kite]           The kite instance
     * */
    public fun changeContext(
        updatedContext: Context
    ): Kite = apply {
        context = updatedContext
    }

    /**
     * Fetches [String]s from resources.
     * [Context.getString()] is used to resolve the id.
     * There is also a vararg variant which accepts format arguments, and maps to the appropriate [Context.getString()] function.
     * @return [KiteStrings]
     * */
    public val string: KiteStrings by lazy { KiteStrings() }

    /**
     * Fetches [String]s Plurals from resources, given the [String] id and the [Int] quantity.
     * [Resources.getQuantityString()] is used to resolve the id.
     * There is also a vararg variant which accepts format arguments, and maps to the appropriate [Resources.getQuantityString()] function.
     * @return [KitePlurals]
     * */
    public val plural: KitePlurals by lazy { KitePlurals() }

    /**
     * Fetches [CharSequence] Texts from resources.
     * [Context.getText()] is used to resolve the id.
     * @return [KiteTexts]
     * */
    public val text: KiteTexts by lazy { KiteTexts() }

    /**
     * Fetches color [Int]s from resources.
     * [ContextCompat.getColor()] is used to resolve the id.
     * @return [KiteColors]
     * */
    public val color: KiteColors by lazy { KiteColors() }

    /**
     * Fetches [ColorStateList]s from resources.
     * [ContextCompat.getColorStateList()] is used to resolve the id.
     * @return [KiteColorStateLists]
     * */
    public val colorStateList: KiteColorStateLists by lazy { KiteColorStateLists() }

    /**
     * Fetches [Boolean]s from resources.
     * [Resources.getBoolean()] is used to resolve the id.
     * @return [KiteBools]
     * */
    public val bools: KiteBools by lazy { KiteBools() }

    /**
     * Fetches ID [Int]s from resources, given the definition type and package.
     * [Resources.getIdentifier()] is used to resolve the id.
     * @return [KiteIdentifier]
     * */
    public val identifier: KiteIdentifier by lazy { KiteIdentifier() }

    /**
     * Fetches [Drawable]s from resources.
     * [ContextCompat.getDrawable()] is used to resolve the id.
     * There is also a variant which accepts a [Resources.Theme?] arguments, and maps to the [Resources.getDrawable()] function.
     * @return [KiteDrawables]
     * */
    public val drawable: KiteDrawables by lazy { KiteDrawables() }

    /**
     * Fetches [Animation]s from resources.
     * [AnimationUtils.loadAnimation()] is used to resolve the id.
     * @return [KiteAnimations]
     * */
    public val animation: KiteAnimations by lazy { KiteAnimations() }

    /**
     * Fetches [Interpolator]s from resources.
     * [AnimationUtils.loadInterpolator()] is used to resolve the id.
     * @return [KiteInterpolators]
     * */
    public val interpolator: KiteInterpolators by lazy { KiteInterpolators() }

    /**
     * Fetches [IntArray]s from resources.
     * [Resources.getIntArray()] is used to resolve the id.
     * @return [KiteIntArrays]
     * */
    public val intArray: KiteIntArrays by lazy { KiteIntArrays() }

    /**
     * Fetches String Arrays ([Array<String>]) from resources.
     * [Resources.getStringArray()] is used to resolve the id.
     * @return [KiteStrings]
     * */
    public val stringArray: KiteStringArrays by lazy { KiteStringArrays() }

    /**
     * Fetches [TypedArray]s from resources.
     * [Resources.obtainTypedArray()] is used to resolve the id.
     * @return [KiteTypedArrays]
     * */
    public val typedArray: KiteTypedArrays by lazy { KiteTypedArrays() }

    /**
     * Fetches Dimension [Float]s from resources.
     * [Resources.getDimension()] is used to resolve the id.
     * @return [KiteDimensions]
     * */
    public val dimension: KiteDimensions by lazy { KiteDimensions() }

    /**
     * Fetches [Int]s from resources.
     * [Resources.getInteger()] is used to resolve the id.
     * @return [KiteIntegers]
     * */
    public val integer: KiteIntegers by lazy { KiteIntegers() }

    /**
     * Fetches fractions [Float]s from resources, given the value base and the parent value base.
     * [Resources.getFraction()] is used to resolve the id.
     * @return [KiteFraction]
     * */
    public val fraction: KiteFraction by lazy { KiteFraction() }

    /**
     * Fetches Layout [XmlResourceParser]s from resources.
     * [Resources.getLayout()] is used to resolve the id.
     * @return [KiteLayouts]
     * */
    public val layout: KiteLayouts by lazy { KiteLayouts() }

    /**
     * Fetches [InputStream]s from resources.
     * [Resources.openRawResource()] is used to resolve the id.
     * There is also a parameterized variant which accepts a [TypedValue], which maps to the appropriate [Resources.openRawResource()] function.
     * @return [KiteRaws]
     * */
    public val raw: KiteRaws by lazy { KiteRaws() }

    /**
     * Fetches Layout [XmlResourceParser]s from resources.
     * [Resources.getXml()] is used to resolve the id.
     * @return [KiteXmls]
     * */
    public val xml: KiteXmls by lazy { KiteXmls() }

    /**
     * Requires API 26 (O)
     * Fetches Layout [Typeface]s from resources.
     * [Resources.getFont()] is used to resolve the id.
     * @return [KiteFonts]
     * */
    public val font: KiteFonts by lazy { KiteFonts() }
}