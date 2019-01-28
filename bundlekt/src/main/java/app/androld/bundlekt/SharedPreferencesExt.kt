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

import android.content.SharedPreferences
import kotlin.reflect.KProperty


class SharedPreferencesLong(
    private val defValue: Long = 0,
    private val key: String? = null
) {
    operator fun getValue(thisRef: SharedPreferences, p: KProperty<*>): Long {
        return thisRef.getLong(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: SharedPreferences, p: KProperty<*>, v: Long) {
        thisRef.edit().putLong(p.name, v).apply()
    }
}

class SharedPreferencesBoolean(
    private val defValue: Boolean = false,
    private val key: String? = null
) {
    operator fun getValue(thisRef: SharedPreferences, p: KProperty<*>): Boolean {
        return thisRef.getBoolean(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: SharedPreferences, p: KProperty<*>, v: Boolean) {
        thisRef.edit().putBoolean(key ?: p.name, v).apply()
    }
}

class SharedPreferencesString(
    private val defValue: String? = null,
    private val key: String? = null
) {
    operator fun getValue(thisRef: SharedPreferences, p: KProperty<*>): String? {
        return thisRef.getString(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: SharedPreferences, p: KProperty<*>, v: String?) {
        thisRef.edit().putString(key ?: p.name, v).apply()
    }
}

class SharedPreferencesInt(
    private val defValue: Int = 0,
    private val key: String? = null
) {
    operator fun getValue(thisRef: SharedPreferences, p: KProperty<*>): Int {
        return thisRef.getInt(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: SharedPreferences, p: KProperty<*>, v: Int) {
        thisRef.edit().putInt(key ?: p.name, v).apply()
    }
}

class SharedPreferencesStringSet(
    private val defValue: Set<String>? = null,
    private val key: String? = null
) {
    operator fun getValue(thisRef: SharedPreferences, p: KProperty<*>): Set<String>? {
        return thisRef.getStringSet(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: SharedPreferences, p: KProperty<*>, v: Set<String>?) {
        thisRef.edit().putStringSet(key ?: p.name, v).apply()
    }
}

class SharedPreferencesFloat(
    private val defValue: Float = 0f,
    private val key: String? = null
) {
    operator fun getValue(thisRef: SharedPreferences, p: KProperty<*>): Float {
        return thisRef.getFloat(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: SharedPreferences, p: KProperty<*>, v: Float) {
        thisRef.edit().putFloat(key ?: p.name, v).apply()
    }
}

class SharedPreferencesEnum<T : Enum<T>>(
    private val clazz: Class<T>,
    private val defValue: T? = null,
    private val key: String? = null
) {
    operator fun getValue(thisRef: SharedPreferences, p: KProperty<*>): T? {
        return thisRef.getString(key ?: p.name, null)?.let {
            runCatching { java.lang.Enum.valueOf(clazz, it) }
                .onFailure { it.printStackTrace() }
                .getOrNull()
        }
            ?: defValue
    }

    operator fun setValue(thisRef: SharedPreferences, p: KProperty<*>, v: T?) {
        thisRef.edit().putString(p.name, v?.name).apply()
    }
}

class SPLong(
    private val sp: SharedPreferences,
    private val defValue: Long = 0,
    private val key: String? = null
) {
    operator fun getValue(thisRef: Any?, p: KProperty<*>): Long {
        return sp.getLong(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: Long) {
        sp.edit().putLong(p.name, v).apply()
    }
}

class SPBoolean(
    private val sp: SharedPreferences,
    private val defValue: Boolean = false,
    private val key: String? = null
) {
    operator fun getValue(thisRef: Any?, p: KProperty<*>): Boolean {
        return sp.getBoolean(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: Boolean) {
        sp.edit().putBoolean(key ?: p.name, v).apply()
    }
}

class SPString(
    private val sp: SharedPreferences,
    private val defValue: String? = null,
    private val key: String? = null
) {
    operator fun getValue(thisRef: Any?, p: KProperty<*>): String? {
        return sp.getString(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: String?) {
        sp.edit().putString(key ?: p.name, v).apply()
    }
}

class SPInt(
    private val sp: SharedPreferences,
    private val defValue: Int = 0,
    private val key: String? = null
) {
    operator fun getValue(thisRef: Any?, p: KProperty<*>): Int {
        return sp.getInt(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: Int) {
        sp.edit().putInt(key ?: p.name, v).apply()
    }
}

class SPStringSet(
    private val sp: SharedPreferences,
    private val defValue: Set<String>? = null,
    private val key: String? = null
) {
    operator fun getValue(thisRef: Any?, p: KProperty<*>): Set<String>? {
        return sp.getStringSet(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: Set<String>?) {
        sp.edit().putStringSet(key ?: p.name, v).apply()
    }
}

class SPFloat(
    private val sp: SharedPreferences,
    private val defValue: Float = 0f,
    private val key: String? = null
) {
    operator fun getValue(thisRef: Any?, p: KProperty<*>): Float {
        return sp.getFloat(key ?: p.name, defValue)
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: Float) {
        sp.edit().putFloat(key ?: p.name, v).apply()
    }
}

class SPEnum<T : Enum<T>>(
    private val sp: SharedPreferences,
    private val clazz: Class<T>,
    private val defValue: T? = null,
    private val key: String? = null
) {
    operator fun getValue(thisRef: Any?, p: KProperty<*>): T? {
        return sp.getString(key ?: p.name, null)?.let {
            runCatching { java.lang.Enum.valueOf(clazz, it) }
                .onFailure { it.printStackTrace() }
                .getOrNull()
        }
            ?: defValue
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, v: T?) {
        sp.edit().putString(p.name, v?.name).apply()
    }
}





