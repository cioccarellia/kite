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

package com.cioccarellia.kite.fetchers.resources

import android.util.TypedValue
import androidx.annotation.IntRange
import androidx.annotation.RawRes
import com.cioccarellia.kite.fetchers.StandardKiteFetcher
import java.io.InputStream

/**
 * [KiteRaws] Implementation
 * */
public class KiteRaws : StandardKiteFetcher</* @RawRes */ Int, InputStream>() {
    override operator fun get(
        @RawRes @IntRange(from = 1) raw: Int
    ): InputStream = kiteContext.resources.openRawResource(raw)

    public operator fun get(
        @RawRes raw: Int,
        value: TypedValue
    ): InputStream = kiteContext.resources.openRawResource(raw, value)
}