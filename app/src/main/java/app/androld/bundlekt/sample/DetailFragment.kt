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


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import app.androld.bundlekt.ArgInt

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg1 = arguments!!.arg1
        val arg2 = arguments!!.arg2
        val res = arg1 + arg2
        view.findViewById<TextView>(R.id.text).text = "$arg1+$arg2=$res"
        view.findViewById<View>(R.id.buttonOk).setOnClickListener {
            activity!!.setResult(RESULT_OK, Intent().apply { result = res })
            activity!!.finish()
        }
    }

    companion object {
        private var Bundle.arg1 by ArgInt()
        private var Bundle.arg2 by ArgInt()

        fun createInstance(arg1: Int, arg2: Int) = DetailFragment().apply {
            arguments = Bundle().also {
                it.arg1 = arg1
                it.arg2 = arg2
            }
        }
    }
}
