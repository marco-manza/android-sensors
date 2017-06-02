package manzalini.marco.androidsensors

import android.app.Application
import android.content.SharedPreferences

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

class AndroidSensorsApplication : Application() {

    companion object {

        private lateinit var application: AndroidSensorsApplication;

        fun get(): AndroidSensorsApplication {
            return application
        }
    }

    var propertiesManager: PropertiesManager? = null

    override fun onCreate() {
        super.onCreate()
        AndroidSensorsApplication.application = this
    }


}
