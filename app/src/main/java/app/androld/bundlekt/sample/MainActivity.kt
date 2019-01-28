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

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.androld.bundlekt.ExtraInt
import app.androld.bundlekt.LazyPropertyWrapper
import app.androld.bundlekt.PropertyJsonWrapper
import app.androld.bundlekt.SharedPreferencesString
import com.google.gson.Gson
import java.text.DateFormat
import java.util.*

private const val REQUEST_SUM = 123


// Properties
var Intent.sum by ExtraInt()
var SharedPreferences.savedSummand1 by SharedPreferencesString()
var SharedPreferences.savedSummand2 by SharedPreferencesString()
var SharedPreferences.lastResultJson by SharedPreferencesString()

class MainActivity : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences

    //Lazy property
    private var lastResultJson: String? by LazyPropertyWrapper { preferences::lastResultJson }

    //Json property
    private var lastResult: LastResult? by PropertyJsonWrapper(
        ::lastResultJson,
        LastResult::class.java,
        Gson()
    )

    private val editText1 by lazy { findViewById<EditText>(R.id.editText1) }
    private val editText2 by lazy { findViewById<EditText>(R.id.editText2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        if (savedInstanceState == null) {
            editText1.setText(preferences.savedSummand1)
            editText2.setText(preferences.savedSummand2)
        }
        Log.i("rom", "lastResult: $lastResult")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        preferences.savedSummand1 = editText1.text.toString()
        preferences.savedSummand2 = editText2.text.toString()
    }

    fun onClickCalculate(v: View) {
        val summand1 = editText1.text.toString().toIntOrNull()
        val summand2 = editText2.text.toString().toIntOrNull()

        if (summand1 == null || summand2 == null) {
            Toast.makeText(this, "Need filled summands", Toast.LENGTH_SHORT).show()
        } else {
            startActivityForResult(
                DetailActivity.createIntent(this, summand1, summand2),
                REQUEST_SUM
            )
        }
    }

    fun onClickLastResult(v: View) {
        Toast.makeText(this, "Saved: $lastResult", Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_SUM -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    lastResult =
                            LastResult(data.sum, DateFormat.getDateTimeInstance().format(Date()))
                    Toast.makeText(this, "Result: ${data.sum}", Toast.LENGTH_SHORT).show()
                }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }

}
