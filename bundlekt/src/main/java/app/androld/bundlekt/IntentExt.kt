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

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable
import kotlin.reflect.KProperty

class ExtraLong(private val defaultValue: Long = 0) {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Long {
        return thisRef.getLongExtra(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Long) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraLongArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): LongArray? {
        return thisRef.getLongArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: LongArray?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraShort(private val defaultValue: Short = 0) {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Short {
        return thisRef.getShortExtra(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Short) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraShortArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): ShortArray? {
        return thisRef.getShortArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: ShortArray?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraByte(private val defaultValue: Byte = 0) {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Byte {
        return thisRef.getByteExtra(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Byte) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraByteArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): ByteArray? {
        return thisRef.getByteArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: ByteArray?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraChar(private val defaultValue: Char = 0.toChar()) {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Char {
        return thisRef.getCharExtra(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Char) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraCharArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): CharArray? {
        return thisRef.getCharArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: CharArray?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraDouble(private val defaultValue: Double = 0.0) {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Double {
        return thisRef.getDoubleExtra(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Double) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraDoubleArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): DoubleArray? {
        return thisRef.getDoubleArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: DoubleArray?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraFloat(private val defaultValue: Float = 0f) {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Float {
        return thisRef.getFloatExtra(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Float) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraFloatArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): FloatArray? {
        return thisRef.getFloatArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: FloatArray?) {
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

class ExtraStringArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Array<String>? {
        return thisRef.getStringArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Array<String>?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraStringNullableArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Array<String?>? {
        return thisRef.getStringArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Array<String?>?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraStringArrayList {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): ArrayList<String>? {
        return thisRef.getStringArrayListExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: ArrayList<String>?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraCharSequence {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): CharSequence? {
        return thisRef.getCharSequenceExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: CharSequence?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraCharSequenceArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Array<CharSequence>? {
        return thisRef.getCharSequenceArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Array<CharSequence>?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraCharSequenceNullableArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Array<CharSequence?>? {
        return thisRef.getCharSequenceArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Array<CharSequence?>?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraCharSequenceArrayList {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): ArrayList<CharSequence>? {
        return thisRef.getCharSequenceArrayListExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: ArrayList<CharSequence>?) {
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

class ExtraBooleanArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): BooleanArray? {
        return thisRef.getBooleanArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: BooleanArray?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraInt(private val defaultValue: Int = 0) {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Int {
        return thisRef.getIntExtra(p.name, defaultValue)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Int) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraIntArray {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): IntArray? {
        return thisRef.getIntArrayExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: IntArray?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraIntegerArrayList {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): ArrayList<Int>? {
        return thisRef.getIntegerArrayListExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: ArrayList<Int>?) {
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
    operator fun getValue(thisRef: Intent, p: KProperty<*>): T? {
        return thisRef.getParcelableExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: T?) {
        thisRef.putExtra(p.name, v)
    }
}


class ExtraParcelableArray<T : Parcelable> {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Array<T>? {
        @Suppress("UNCHECKED_CAST")
        return thisRef.getParcelableArrayExtra(p.name) as Array<T>?
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Array<T>?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraParcelableNullableArray<T : Parcelable?> {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): Array<T>? {
        @Suppress("UNCHECKED_CAST")
        return thisRef.getParcelableArrayExtra(p.name) as Array<T>?
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: Array<T>?) {
        thisRef.putExtra(p.name, v)
    }
}

class ExtraParcelableArrayList<T : Parcelable> {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): ArrayList<T>? {
        return thisRef.getParcelableArrayListExtra(p.name)
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: ArrayList<T>?) {
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

class ExtraEnum<T : Enum<T>>(private val clazz: Class<T>) {
    operator fun getValue(thisRef: Intent, p: KProperty<*>): T? {
        return thisRef.getStringExtra(p.name)?.let {
            runCatching { java.lang.Enum.valueOf(clazz, it) }
                .onFailure { it.printStackTrace() }
                .getOrNull()
        }
    }

    operator fun setValue(thisRef: Intent, p: KProperty<*>, v: T?) {
        thisRef.putExtra(p.name, v?.name)
    }
}

