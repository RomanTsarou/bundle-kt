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
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.util.*

private const val REQUEST_RESULT = 123

class MainActivity : AppCompatActivity() {
    private val repository by lazy { Repository(this) }
    private val editText1 by lazy { findViewById<EditText>(R.id.editText1) }
    private val editText2 by lazy { findViewById<EditText>(R.id.editText2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            editText1.setText(repository.preferences.savedArg1)
            editText2.setText(repository.preferences.savedArg2)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        repository.preferences.savedArg1 = editText1.text.toString()
        repository.preferences.savedArg2 = editText2.text.toString()
    }

    fun onClickCalculate(v: View) {
        val arg1 = editText1.text.toString().toIntOrNull()
        val arg2 = editText2.text.toString().toIntOrNull()

        if (arg1 == null || arg2 == null) {
            Toast.makeText(this, "Need filled args", Toast.LENGTH_SHORT).show()
        } else {
            startActivityForResult(DetailActivity.createIntent(this, arg1, arg2), REQUEST_RESULT)
        }
    }

    fun onClickLastResult(v: View) {
        Toast.makeText(this, "Last result: ${repository.lastResult}", Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_RESULT -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    repository.lastResult =
                            LastResult(data.result, DateFormat.getDateTimeInstance().format(Date()))
                    Toast.makeText(this, "Result: ${data.result}", Toast.LENGTH_SHORT).show()
                }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }

}
