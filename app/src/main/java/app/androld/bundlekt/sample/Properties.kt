package app.androld.bundlekt.sample

import android.content.Intent
import android.content.SharedPreferences
import app.androld.bundlekt.ExtraInt
import app.androld.bundlekt.SharedPreferencesString

var Intent.result by ExtraInt()
var SharedPreferences.savedArg1 by SharedPreferencesString()
var SharedPreferences.savedArg2 by SharedPreferencesString()