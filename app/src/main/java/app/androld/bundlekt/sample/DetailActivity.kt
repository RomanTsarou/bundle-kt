package app.androld.bundlekt.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.androld.bundlekt.ExtraInt

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    android.R.id.content, DetailFragment.createInstance(
                        intent.extra1,
                        intent.extra2
                    )
                )
        }
    }

    companion object {
        private var Intent.extra1 by ExtraInt()
        private var Intent.extra2 by ExtraInt()
        var Intent.result by ExtraInt()

        fun createIntent(context: Context, arg1: Int, arg2: Int) =
            Intent(context, DetailActivity::class.java).apply {
                extra1 = arg1
                extra2 = arg2
            }
    }
}
