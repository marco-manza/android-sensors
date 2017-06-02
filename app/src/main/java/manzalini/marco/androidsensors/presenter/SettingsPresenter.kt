package manzalini.marco.androidsensors.presenter

import android.preference.PreferenceManager
import manzalini.marco.androidsensors.PropertiesManager
import manzalini.marco.androidsensors.view.SettingsView

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

class SettingsPresenter : BasePresenter<SettingsView>() {

    override fun attachView(view: SettingsView) {
        super.attachView(view)
        view.displayUrl(PropertiesManager.instance.getUrl())
    }

    fun saveUrl(url: String) {
        PropertiesManager.instance.setUrl(url)
        view?.dismissView()
    }

}
