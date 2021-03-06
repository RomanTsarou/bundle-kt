/*
 * Copyright (c) 2018 Roman Tsarou
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.androld.bundlekt.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.androld.bundlekt.ExtraInt

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    android.R.id.content, DetailFragment.createInstance(
                        intent.extra1,
                        intent.extra2
                    )
                ).commit()
        }
    }

    companion object {
        private var Intent.extra1 by ExtraInt()
        private var Intent.extra2 by ExtraInt()

        fun createIntent(context: Context, summand1: Int, summand2: Int) =
            Intent(context, DetailActivity::class.java).apply {
                extra1 = summand1
                extra2 = summand2
            }
    }
}
