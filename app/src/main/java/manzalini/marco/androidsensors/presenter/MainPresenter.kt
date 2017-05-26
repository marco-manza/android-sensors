package manzalini.marco.androidsensors.presenter

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import com.tbruyelle.rxpermissions2.RxPermissions
import manzalini.marco.androidsensors.AccellerometerListener
import manzalini.marco.androidsensors.GyroscopeListener
import manzalini.marco.androidsensors.view.MainView

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

class MainPresenter : BasePresenter<MainView>() {

    lateinit private var sensorManager: SensorManager
    lateinit private var locationManager: LocationManager

    lateinit private var accelerometerListener: AccellerometerListener
    lateinit private var gyroscopeListener: GyroscopeListener
    lateinit private var locationListener: LocationListener

    companion object {
        private val TAG = MainPresenter::class.java.simpleName
    }

    @SuppressLint("MissingPermission")
    override fun attachView(view: MainView) {
        super.attachView(view)
        RxPermissions(view.getContext() as Activity)
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe { granted ->
                    if (granted) {
                        println("Granted")
                    } else {
                        println("Not granted")
                    }
                }
        accelerometerListener = object : AccellerometerListener() {
            override fun onAccelerometerValuesChanged(x: Float, y: Float, z: Float) {
                view.displayAccelerometerValues(x, y, z)
            }
        }
        gyroscopeListener = object : GyroscopeListener() {
            override fun onGyroscopeValuesChanged(x: Float, y: Float, z: Float) {
                view.displayGyroscopeValues(x, y, z)
            }
        }

        sensorManager = view.getContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        sensorManager.registerListener(accelerometerListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(gyroscopeListener, gyro, SensorManager.SENSOR_DELAY_NORMAL)

        //location
        locationManager = view.getContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location?) {
                view.displayGpsValues(location)
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            }

            override fun onProviderEnabled(provider: String?) {
            }

            override fun onProviderDisabled(provider: String?) {
            }

        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 1f, locationListener)

    }

    override fun detachView() {
        super.detachView()
        sensorManager.unregisterListener(accelerometerListener)
        sensorManager.unregisterListener(gyroscopeListener)
        locationManager.removeUpdates(locationListener)
    }

}
