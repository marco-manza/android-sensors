package manzalini.marco.androidsensors.service

import io.reactivex.Observable
import manzalini.marco.androidsensors.api.ServiceApi
import manzalini.marco.androidsensors.model.SensorDataDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

class AppService {

    fun send(sensorData: SensorDataDto): Observable<Response<ResponseBody>> {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ServiceApi::class.java)
                .sendData(sensorData)
    }
}
