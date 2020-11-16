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
import com.cioccarellia.kite.delegate.KiteDelegate
import com.cioccarellia.kite.resparser.compat.KiteColorStateLists
import com.cioccarellia.kite.resparser.compat.KiteColors
import com.cioccarellia.kite.resparser.compat.KiteDrawables
import com.cioccarellia.kite.resparser.context.KiteStrings
import com.cioccarellia.kite.resparser.context.KiteTexts
import com.cioccarellia.kite.resparser.custom.KiteAnimations
import com.cioccarellia.kite.resparser.custom.KiteInterpolators
import com.cioccarellia.kite.resparser.resources.*

class Kite internal constructor() {
    companion object {
        internal lateinit var appContext: Context
        fun fly(applicationContext: Context) = KiteDelegate().also {
            appContext = applicationContext
        }
    }

    val string by lazy { KiteStrings() }
    val plural by lazy { KitePlurals() }
    val text by lazy { KiteTexts() }

    val color by lazy { KiteColors() }
    val colorStateList by lazy { KiteColorStateLists() }

    val drawable by lazy { KiteDrawables() }
    val animation by lazy { KiteAnimations() }
    val interpolator by lazy { KiteInterpolators() }

    val intArray by lazy { KiteIntArrays() }
    val stringArray by lazy { KiteStringArrays() }
    val typedArray by lazy { KiteTypedArrays() }

    val dimension by lazy { KiteDimensions() }

    val integer by lazy { KiteIntegers() }

    val layout by lazy { KiteLayouts() }

    val raw by lazy { KiteRaws() }
    val xml by lazy { KiteXmls() }

    val font by lazy { KiteFonts() }
}