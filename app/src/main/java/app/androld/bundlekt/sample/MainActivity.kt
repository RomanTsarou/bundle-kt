package app.androld.bundlekt.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val REQUEST_RESULT = 123

class MainActivity : AppCompatActivity() {
    private val sharedPreferences by lazy { PreferenceManager.getDefaultSharedPreferences(this) }
    private val editText1 by lazy { findViewById<EditText>(R.id.editText1) }
    private val editText2 by lazy { findViewById<EditText>(R.id.editText2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            editText1.setText(sharedPreferences.savedArg1)
            editText2.setText(sharedPreferences.savedArg2)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        sharedPreferences.savedArg1 = editText1.text.toString()
        sharedPreferences.savedArg2 = editText2.text.toString()
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_RESULT -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    Toast.makeText(this, "Result: ${data.result}", Toast.LENGTH_SHORT).show()
                }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
