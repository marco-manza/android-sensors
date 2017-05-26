package manzalini.marco.androidsensors.presenter

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.Log

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import manzalini.marco.androidsensors.AccellerometerListener
import manzalini.marco.androidsensors.GyroscopeListener
import manzalini.marco.androidsensors.model.SensorDataDto
import manzalini.marco.androidsensors.service.AppService
import manzalini.marco.androidsensors.view.MainView
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

class MainPresenter : BasePresenter<MainView>() {

    lateinit private var sensorManager: SensorManager
    lateinit private var accelerometerListener: AccellerometerListener
    lateinit private var gyroscopeListener: GyroscopeListener

    companion object {
        private val TAG = MainPresenter::class.java.simpleName
    }

    override fun attachView(view: MainView) {
        super.attachView(view)
        accelerometerListener = object : AccellerometerListener() {
            override fun onAccelerometerValuesChanged(x: Float, y: Float, z: Float) {
                view.displayAccelerometerValues(x, y, z)
            }
        }
        gyroscopeListener = object : GyroscopeListener(){
            override fun onGyroscopeValuesChanged(x: Float, y: Float, z: Float) {
                view.displayGyroscopeValues(x, y, z)
            }
        }

        sensorManager = view.getContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        sensorManager.registerListener(accelerometerListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(gyroscopeListener, gyro, SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun detachView() {
        super.detachView()
        sensorManager.unregisterListener(accelerometerListener)
        sensorManager.unregisterListener(gyroscopeListener)
    }

}
