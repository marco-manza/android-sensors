package manzalini.marco.androidsensors

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

class PropertiesManager private constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        val instance: PropertiesManager by lazy {
            val defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AndroidSensorsApplication.get())
            return@lazy PropertiesManager(defaultSharedPreferences)
        }
        val KEY_URL = "KEY_URL__"
    }

    fun getUrl(): String = sharedPreferences.getString(KEY_URL, "")

    @SuppressLint("ApplySharedPref")
    fun setUrl(url: String) {
        sharedPreferences.edit()
                .putString(KEY_URL, url)
                .commit()
    }

}
