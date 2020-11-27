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
package com.cioccarellia.sample

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.cioccarellia.kite.Kite
import com.cioccarellia.kite.extensions.runInContext

class MainActivity : AppCompatActivity() {
    private val inputView by lazy { findViewById<TextView>(R.id.inputView) }
    private val buttonView by lazy { findViewById<Button>(R.id.buttonView) }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputView.setHintTextColor(
            Kite.color[R.color.md_red]
        )

        // Runs inside activity context
        Kite.color.runInContext(this) {
            buttonView.setBackgroundColor(
                Kite.color[R.color.colorAccent]
            )
        }
    }
}