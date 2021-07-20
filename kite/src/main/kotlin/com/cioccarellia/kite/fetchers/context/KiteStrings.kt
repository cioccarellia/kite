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

package com.cioccarellia.kite.fetchers.context

import androidx.annotation.IntRange
import androidx.annotation.StringRes
import com.cioccarellia.kite.fetchers.StandardKiteFetcher

/**
 * [KiteStrings] Implementation
 * */
public class KiteStrings : StandardKiteFetcher</* @StringRes */ Int, String>() {
    override operator fun get(
        @StringRes @IntRange(from = 1) string: Int
    ): String = kiteContext.getString(string)

    public operator fun get(
        @StringRes @IntRange(from = 1) string: Int,
        vararg formatArguments: Any
    ): String = kiteContext.getString(string, *formatArguments)
}