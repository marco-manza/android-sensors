package manzalini.marco.androidsensors.view

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

interface MainView : MvpView {
    fun displayAccelerometerValues(x: Float, y: Float, z: Float)
    fun displayGyroscopeValues(x: Float, y: Float, z: Float)

}
