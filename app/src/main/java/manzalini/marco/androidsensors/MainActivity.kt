package manzalini.marco.androidsensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import manzalini.marco.androidsensors.presenter.MainPresenter
import manzalini.marco.androidsensors.view.MainView

class MainActivity : AppCompatActivity(), MainView {
    var presenter: MainPresenter = MainPresenter()
    lateinit var accX: TextView
    lateinit var accY: TextView
    lateinit var accZ: TextView
    lateinit var gyroRoll: TextView
    lateinit var gyroPitch: TextView
    lateinit var gyroYaw: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        initView()
    }

    private fun initView() {
        accX = findViewById(R.id.acc_x) as TextView
        accY = findViewById(R.id.acc_y) as TextView
        accZ = findViewById(R.id.acc_z) as TextView

        gyroPitch = findViewById(R.id.gyro_pitch) as TextView
        gyroRoll = findViewById(R.id.gyro_roll) as TextView
        gyroYaw = findViewById(R.id.gyro_yaw) as TextView
    }

    override fun displayAccelerometerValues(x: Float, y: Float, z: Float) {
        accX.text = x.toString()
        accY.text = y.toString()
        accZ.text = z.toString()
    }

    override fun displayGyroscopeValues(x: Float, y: Float, z: Float) {
        gyroPitch.text = x.toString()
        gyroRoll.text = y.toString()
        gyroYaw.text = z.toString()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun getContext(): Context {
        return this
    }

}
