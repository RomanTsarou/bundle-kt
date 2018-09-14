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

package app.androld.bundlekt

import com.google.gson.Gson
import java.util.concurrent.atomic.AtomicReference
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

/**
 * Created by Roman Tsarou on 05.09.2018.
 */


class PropertyWrapper<T>(private val parent: KMutableProperty0<T>) {
    operator fun getValue(thisRef: Any, p: KProperty<*>): T {
        return parent.get()
    }

    operator fun setValue(thisRef: Any, p: KProperty<*>, v: T) {
        parent.set(v)
    }
}

class PropertyJsonWrapper<T>(
    private val parent: KMutableProperty0<String?>,
    private val clazz: Class<T>,
    private val gson: Gson,
    private val observer: ((newValue: T?) -> Unit)? = null
) {
    private lateinit var value: AtomicReference<T?>
    operator fun getValue(thisRef: Any, p: KProperty<*>): T? {
        if (!::value.isInitialized) {
            val json = parent.get() ?: ""
            value = AtomicReference(gson.fromJson(json, clazz))
        }

        return value.get()
    }

    operator fun setValue(thisRef: Any, p: KProperty<*>, v: T?) {
        if (!::value.isInitialized) {
            value = AtomicReference()
        }
        value.set(v)
        val json = v?.let { gson.toJson(it) }
        parent.set(json)
        observer?.invoke(v)
    }
}