package app.androld.bundlekt

import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

/**
 * Created by Roman Tsarou on 05.09.2018.
 */


private class PropertyWrapper<T>(private val parent: KMutableProperty0<T>) {
    operator fun getValue(thisRef: Any, p: KProperty<*>): T {
        return parent.get()
    }

    operator fun setValue(thisRef: Any, p: KProperty<*>, v: T) {
        parent.set(v)
    }
}