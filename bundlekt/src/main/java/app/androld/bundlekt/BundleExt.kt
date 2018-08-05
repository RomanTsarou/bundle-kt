package app.androld.bundlekt

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable
import kotlin.reflect.KProperty

class ArgString {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): String? {
        return thisRef.getString(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: String?) {
        thisRef.putString(p.name, v)
    }
}

class ArgLong {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Long {
        return thisRef.getLong(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Long) {
        thisRef.putLong(p.name, v)
    }
}

class ArgInt {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Int {
        return thisRef.getInt(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Int) {
        thisRef.putInt(p.name, v)
    }
}

class ArgBoolean {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Boolean {
        return thisRef.getBoolean(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Boolean) {
        thisRef.putBoolean(p.name, v)
    }
}


class ArgParcelable<T : Parcelable> {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): T {
        return thisRef.getParcelable(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: T) {
        thisRef.putParcelable(p.name, v)
    }
}

class ArgParcelableArrayList<T : Parcelable> {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): ArrayList<T> {
        return thisRef.getParcelableArrayList(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: ArrayList<T>) {
        thisRef.putParcelableArrayList(p.name, v)
    }
}

class ArgSerializable<T : Serializable> {
    @Suppress("UNCHECKED_CAST")
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): T? {
        return thisRef.getSerializable(p.name) as T?
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: T?) {
        thisRef.putSerializable(p.name, v)
    }
}

//    INTENT
class ExtraLong {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Long {
        return thisRef.getLongExtra(p.name, 0)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Long) {
        thisRef.putExtra(p.name, v)
    }
}


class ExtraString {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): String? {
        return thisRef.getStringExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: String?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraBoolean(private val defValue: Boolean = false) {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Boolean {
        return thisRef.getBooleanExtra(p.name, defValue)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Boolean) {
        thisRef.putExtra(p.name, v)
    }
}


class ExtraInt {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Int {
        return thisRef.getIntExtra(p.name, 0)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Int) {
        thisRef.putExtra(p.name, v)
    }
}


class ExtraSerializable<T : Serializable> {
    @Suppress("UNCHECKED_CAST")
    operator fun getValue(thisRef: Intent, p: KProperty<*>): T? {
        return thisRef.getSerializableExtra(p.name) as T?
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: T?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraParcelable<T : Parcelable> {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): T {
        return thisRef.getParcelableExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: T) {
        thisRef.putExtra(p.name, v)
    }
}


class ExtraParcelableArrayList<T : Parcelable> {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): ArrayList<T> {
        return thisRef.getParcelableArrayListExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: ArrayList<T>) {
        thisRef.putParcelableArrayListExtra(p.name, v)
    }
}

class ExtraBundle {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Bundle? {
        return thisRef.getBundleExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Bundle?) {
        thisRef.putExtra(p.name, v)
    }
}

// SharedPreferences
class SharedPreferencesLong(private val defValue: Long = 0) {
    operator fun getValue(thisRef: SharedPreferences, p: KProperty<*>): Long {
        return thisRef.getLong(p.name, defValue)
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




