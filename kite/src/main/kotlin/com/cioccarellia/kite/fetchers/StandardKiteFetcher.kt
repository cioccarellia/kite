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

/**
 * [KiteFetcher] which is defined to have precisely 1 input type [R] (Resource) and 1 output type [O] (Output).
 * It compatible and backed by the index operator with a canonical signature.
 * */
public abstract class StandardKiteFetcher<in R, out O> : KiteFetcher() {
    /**
     * @param resource The resource identifier [R]
     * @return [O] The fetched resource [O]
     * */
    public abstract operator fun get(resource: R): O
}