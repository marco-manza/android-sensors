package manzalini.marco.androidsensors.presenter

import manzalini.marco.androidsensors.view.MvpView

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

abstract class BasePresenter<T : MvpView> : Presenter<T> {

    protected var view: T? = null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}
