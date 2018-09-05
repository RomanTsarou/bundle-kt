# bundle-kt
[![Release](https://jitpack.io/v/RomanTsarou/bundle-kt.svg)](https://jitpack.io/#RomanTsarou/bundle-kt)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

Easy use Bundle, Intent, SharedPreferences in Kotlin

####Use:
```
    companion object {
        var SharedPreferences.userName by SharedPreferencesString()
    }

...

fun setName(newName: String) {
    val oldName = sharedPreferences.userName
    if (oldName != newName) {
        sharedPreferences.userName = newName
    }
}

