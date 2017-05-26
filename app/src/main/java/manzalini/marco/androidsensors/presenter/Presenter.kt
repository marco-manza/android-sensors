package manzalini.marco.androidsensors.presenter

import manzalini.marco.androidsensors.view.MvpView

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

interface Presenter<in T : MvpView> {

    fun attachView(view: T)

    fun detachView()
}
