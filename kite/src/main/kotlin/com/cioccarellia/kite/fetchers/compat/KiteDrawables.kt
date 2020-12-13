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
@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package com.cioccarellia.kite.fetchers.compat

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.cioccarellia.kite.fetchers.StandardKiteFetcher

/**
 * [KiteDrawables] Implementation
 * */
public class KiteDrawables : StandardKiteFetcher<@DrawableRes Int, Drawable>() {
    override operator fun get(
        @DrawableRes @IntRange(from = 1) drawable: Int
    ): Drawable = ContextCompat.getDrawable(kiteContext, drawable)!!

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public operator fun get(
        @DrawableRes @IntRange(from = 1) drawable: Int,
        theme: Resources.Theme?
    ): Drawable = kiteContext.resources.getDrawable(drawable, theme)!!
}