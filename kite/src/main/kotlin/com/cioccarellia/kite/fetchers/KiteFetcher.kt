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
package com.cioccarellia.kite.fetchers

import android.content.Context
import androidx.annotation.RestrictTo
import com.cioccarellia.kite.Kite
import com.cioccarellia.kite.internal.switchContext

/**
 * Represents a kite fetcher, which is responsible for fetching resources using the Android framework.
 * It provides [Context] access to the kite context
 * */
public abstract class KiteFetcher {
    internal val kiteContext: Context
        @RestrictTo(RestrictTo.Scope.LIBRARY)
        get() {
            return Kite.context
        }
}

/**
 * Temporarily switches context to execute the given lambda
 *
 * @param [context]     The context to be temporarily set as the new kite context while the lambda runs
 * @param [block]       The lambda to be executed
 * */
public inline fun <T : KiteFetcher> T.runWith(context: Context, block: (T) -> Unit): T = switchContext(context, block)

public fun <T : KiteFetcher> T.changeContext(context: Context): T = apply { Kite.changeContext(context) }