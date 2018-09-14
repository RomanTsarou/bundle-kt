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
import android.content.SharedPreferences
import android.preference.PreferenceManager
import app.androld.bundlekt.PropertyJsonWrapper
import com.google.gson.Gson

/**
 * Created by Roman Tsarou on 14.09.2018.
 */
class Repository(context: Context) {
    val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    var lastResult: LastResult? by PropertyJsonWrapper(
        preferences::lastResultJson,
        LastResult::class.java,
        Gson()
    )
}