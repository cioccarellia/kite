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

package com.cioccarellia.kite.extensions

import android.content.Context
import com.cioccarellia.kite.Kite
import com.cioccarellia.kite.resparser.KiteParser

/**
 * @return kite [Context] reference
 * */
public fun getKiteContext(): Context = Kite.context

/**
 * Permanently changes the context used by kite
 * @param [context]     The context to be set as the new kite context
 * */
public fun changeKiteContext(context: Context) {
    Kite.context = context
}

/**
 * Permanently changes the context used by kite
 * @param [context]     The context to be set as the new kite context
 * @return [T]          KiteParser instance referencing the new context
 * */
public fun <T : KiteParser> T.changeContext(context: Context): T = apply {
    Kite.context = context
}

/**
 * Temporarily switches context to execute the given lambda
 *
 * @param [context]     The context to be temporarily set as the new kite context while the lambda runs
 * @param [block]       The lambda to be executed
 * @return [T]          KiteParser instance, referencing the same context it was passed with
 * */
public fun <T : KiteParser, R> T.runWith(context: Context, block: T.() -> R): R = run {
    val previousContext = getKiteContext()
    changeContext(context).block().also { changeContext(previousContext) }
}

