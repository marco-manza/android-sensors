package manzalini.marco.androidsensors

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import manzalini.marco.androidsensors.model.SensorDataDto
import manzalini.marco.androidsensors.presenter.MainPresenter
import manzalini.marco.androidsensors.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    var presenter: MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)

        val button = findViewById(R.id.button)
        button.setOnClickListener({ presenter.onButtonClick(SensorDataDto()) })
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }
}
