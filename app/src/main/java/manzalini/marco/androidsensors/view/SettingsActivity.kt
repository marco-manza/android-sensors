package manzalini.marco.androidsensors.view

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import manzalini.marco.androidsensors.R
import manzalini.marco.androidsensors.presenter.SettingsPresenter

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */
class SettingsActivity : AppCompatActivity(), SettingsView {

    private lateinit var inputUrl: EditText
    private lateinit var buttonSave: Button

    private val presenter = SettingsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        inputUrl = findViewById(R.id.input_url) as EditText
        buttonSave = findViewById(R.id.button_save) as Button

        buttonSave.setOnClickListener({ presenter.saveUrl(inputUrl.text.toString()) })

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

    override fun displayUrl(url: String) {
        inputUrl.setText(url)
    }

    override fun dismissView() {
        finish()
    }
}