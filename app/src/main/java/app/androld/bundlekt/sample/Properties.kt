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

import android.content.Intent
import android.content.SharedPreferences
import app.androld.bundlekt.ExtraInt
import app.androld.bundlekt.SharedPreferencesString

var Intent.result by ExtraInt()
var SharedPreferences.savedArg1 by SharedPreferencesString()
var SharedPreferences.savedArg2 by SharedPreferencesString()
