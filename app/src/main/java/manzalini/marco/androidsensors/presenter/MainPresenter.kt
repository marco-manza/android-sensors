package manzalini.marco.androidsensors.presenter

import android.util.Log

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import manzalini.marco.androidsensors.model.SensorDataDto
import manzalini.marco.androidsensors.service.AppService
import manzalini.marco.androidsensors.view.MainView
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

class MainPresenter : BasePresenter<MainView>() {

    companion object {
        private val TAG = MainPresenter::class.java.simpleName
    }

    private val service = AppService()

    fun onButtonClick(data: SensorDataDto) {
        service.send(data)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<ResponseBody>> {
                    override fun onSubscribe(d: Disposable?) {}
                    override fun onNext(value: Response<ResponseBody>) {
                        Log.d(TAG, value.body()?.string())
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                    override fun onComplete() {
                    }
                })
    }


}
