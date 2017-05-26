package manzalini.marco.androidsensors.api

import io.reactivex.Observable
import manzalini.marco.androidsensors.model.SensorDataDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

interface ServiceApi {

    @POST("post")
    fun sendData(@Body sensorData: SensorDataDto): Observable<Response<ResponseBody>>

}
