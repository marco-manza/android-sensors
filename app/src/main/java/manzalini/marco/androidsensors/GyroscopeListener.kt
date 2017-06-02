package manzalini.marco.androidsensors

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

abstract class GyroscopeListener : SensorEventListener {
    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_GYROSCOPE) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            onGyroscopeValuesChanged(x, y, z)
        }
    }

    override final fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
    }

    protected abstract fun onGyroscopeValuesChanged(x: Float, y: Float, z: Float)
}
