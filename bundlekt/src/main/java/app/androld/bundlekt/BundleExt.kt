package app.androld.bundlekt

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import android.util.SparseArray
import java.io.Serializable
import kotlin.reflect.KProperty

class ArgString(private val defaultValue: String? = null) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): String? {
        return thisRef.getString(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: String?) {
        thisRef.putString(p.name, v)
    }
}

class ArgStringArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Array<String?>? {
        return thisRef.getStringArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Array<String?>?) {
        thisRef.putStringArray(p.name, v)
    }
}

class ArgStringArrayList {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): ArrayList<String?>? {
        return thisRef.getStringArrayList(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: ArrayList<String?>?) {
        thisRef.putStringArrayList(p.name, v)
    }
}

class ArgCharSequence(private val defaultValue: CharSequence? = null) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): CharSequence? {
        return thisRef.getCharSequence(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: CharSequence?) {
        thisRef.putCharSequence(p.name, v)
    }
}

class ArgCharSequenceArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Array<CharSequence?>? {
        return thisRef.getCharSequenceArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Array<CharSequence?>?) {
        thisRef.putCharSequenceArray(p.name, v)
    }
}

class ArgCharSequenceArrayList {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): ArrayList<CharSequence?>? {
        return thisRef.getCharSequenceArrayList(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: ArrayList<CharSequence?>?) {
        thisRef.putCharSequenceArrayList(p.name, v)
    }
}

class ArgLong(private val defaultValue: Long = 0) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Long {
        return thisRef.getLong(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Long) {
        thisRef.putLong(p.name, v)
    }
}

class ArgLongArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): LongArray? {
        return thisRef.getLongArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: LongArray?) {
        thisRef.putLongArray(p.name, v)
    }
}

class ArgByte(private val defaultValue: Byte = 0) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Byte {
        return thisRef.getByte(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Byte) {
        thisRef.putByte(p.name, v)
    }
}

class ArgByteArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): ByteArray? {
        return thisRef.getByteArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: ByteArray?) {
        thisRef.putByteArray(p.name, v)
    }
}

class ArgInt(private val defaultValue: Int = 0) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Int {
        return thisRef.getInt(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Int) {
        thisRef.putInt(p.name, v)
    }
}

class ArgIntArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): IntArray? {
        return thisRef.getIntArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: IntArray?) {
        thisRef.putIntArray(p.name, v)
    }
}

class ArgIntegerArrayList {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): ArrayList<Int>? {
        return thisRef.getIntegerArrayList(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: ArrayList<Int>?) {
        thisRef.putIntegerArrayList(p.name, v)
    }
}

class ArgBoolean(private val defaultValue: Boolean = false) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Boolean {
        return thisRef.getBoolean(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Boolean) {
        thisRef.putBoolean(p.name, v)
    }
}

class ArgBooleanArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): BooleanArray? {
        return thisRef.getBooleanArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: BooleanArray?) {
        thisRef.putBooleanArray(p.name, v)
    }
}

class ArgChar(private val defaultValue: Char = 0.toChar()) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Char {
        return thisRef.getChar(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Char) {
        thisRef.putChar(p.name, v)
    }
}

class ArgCharArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): CharArray? {
        return thisRef.getCharArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: CharArray?) {
        thisRef.putCharArray(p.name, v)
    }
}

class ArgFloat(private val defaultValue: Float = 0f) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Float {
        return thisRef.getFloat(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Float) {
        thisRef.putFloat(p.name, v)
    }
}

class ArgFloatArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): FloatArray? {
        return thisRef.getFloatArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: FloatArray?) {
        thisRef.putFloatArray(p.name, v)
    }
}

class ArgShort(private val defaultValue: Short = 0) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Short {
        return thisRef.getShort(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Short) {
        thisRef.putShort(p.name, v)
    }
}

class ArgShortArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): ShortArray? {
        return thisRef.getShortArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: ShortArray?) {
        thisRef.putShortArray(p.name, v)
    }
}

class ArgDouble(private val defaultValue: Double = 0.0) {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Double {
        return thisRef.getDouble(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Double) {
        thisRef.putDouble(p.name, v)
    }
}

class ArgDoubleArray {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): DoubleArray? {
        return thisRef.getDoubleArray(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: DoubleArray?) {
        thisRef.putDoubleArray(p.name, v)
    }
}

class ArgParcelable<T : Parcelable> {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): T? {
        return thisRef.getParcelable(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: T?) {
        thisRef.putParcelable(p.name, v)
    }
}

class ArgParcelableArrayList<T : Parcelable> {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): ArrayList<T?>? {
        return thisRef.getParcelableArrayList(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: ArrayList<T?>?) {
        thisRef.putParcelableArrayList(p.name, v)
    }
}

class ArgParcelableArray<T : Parcelable> {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Array<T?>? {
        @Suppress("UNCHECKED_CAST")
        return thisRef.getParcelableArray(p.name) as Array<T?>?
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Array<T?>?) {
        thisRef.putParcelableArray(p.name, v)
    }
}

class ArgParcelableSparseArray<T : Parcelable> {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): SparseArray<T?>? {
        @Suppress("UNCHECKED_CAST")
        return thisRef.getSparseParcelableArray<T>(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: SparseArray<T?>?) {
        thisRef.putSparseParcelableArray(p.name, v)
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

class ArgBundle {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): Bundle? {
        return thisRef.getBundle(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: Bundle?) {
        thisRef.putBundle(p.name, v)
    }
}

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class ArgBinder {
    operator fun getValue(thisRef: Bundle, p: KProperty<*>): IBinder? {
        return thisRef.getBinder(p.name)
    }

    operator fun setValue(thisRef: Bundle, p: KProperty<*>, v: IBinder?) {
        thisRef.putBinder(p.name, v)
    }
}

