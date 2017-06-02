package manzalini.marco.androidsensors.view

import android.content.Context
import android.content.Intent
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import manzalini.marco.androidsensors.R
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

    lateinit var gpsLatitude: TextView
    lateinit var gpsLongitude: TextView
    lateinit var gpsAccuracy: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar) as Toolbar)
        presenter.attachView(this)
        initView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.clear()
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                return true
            }
            else -> return false
        }

    }

    private fun initView() {
        accX = findViewById(R.id.acc_x) as TextView
        accY = findViewById(R.id.acc_y) as TextView
        accZ = findViewById(R.id.acc_z) as TextView

        gyroPitch = findViewById(R.id.gyro_pitch) as TextView
        gyroRoll = findViewById(R.id.gyro_roll) as TextView
        gyroYaw = findViewById(R.id.gyro_yaw) as TextView

        gpsLatitude = findViewById(R.id.gps_latitude) as TextView
        gpsLongitude = findViewById(R.id.gps_longitude) as TextView
        gpsAccuracy = findViewById(R.id.gps_accuracy) as TextView
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

    override fun displayGpsValues(location: Location?) {
        gpsLatitude.text = "Latitude: " + (location?.latitude ?: "Not available")
        gpsLongitude.text = "Longitude " + (location?.longitude ?: "Not available")
        gpsAccuracy.text = "Accuracy: " + (location?.accuracy ?: "Not available")
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
