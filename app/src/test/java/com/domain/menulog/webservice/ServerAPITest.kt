package com.domain.menulog.webservice

import com.domain.menulog.network.NetworkTest
import com.domain.menulog.modelbean.Stats
import com.domain.menulog.network.WebService
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.ConnectException
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

class ServerAPITest : NetworkTest() {
    lateinit var apiClient : ClientAPI
    var result : List<Stats>? = null

    @Before
    @Throws(Exception::class)
    fun setupService() {
        val apiService = retrofit
                .create(WebService::class.java)

        apiClient = ClientAPI(apiService)
    }

    @Test
    fun serverDown() {
        //invalid url
        val serverUrl = "https://197.123.0.212:8080/"
        var isGetError = false

        val apiService = Retrofit.Builder()
                .baseUrl(serverUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(WebService::class.java)

        apiClient = ClientAPI(apiService)
        apiClient.getStatsList()
                .observeOn(Schedulers.computation())
                .doAfterTerminate { lock.countDown() }
                .subscribe (
                        { assertFalse(true)},
                        { error ->
                            run {
                                assert(error is ConnectException)
                                isGetError = true
                            }
                        }
                )

        lock.await(WAITING, TimeUnit.MILLISECONDS)
        assert(isGetError)
    }

    @Test
    fun validateResponse() {
        setupResponse(fileToString("statsList.json"))

        apiClient.getStatsList()
                .observeOn(Schedulers.computation())
                .doAfterTerminate { lock.countDown() }
                .subscribe (
                        {list -> result = list},
                        {assertFalse(true)}
                )

        lock.await(WAITING, TimeUnit.MILLISECONDS)

        assertEquals(result?.size, 4)
        assertEquals(result?.get(0)?.teamA?.shortName, "Panthers")
        assertEquals(result?.get(0)?.teamA?.topPlayers?.get(0)?.fullName, "Peter Wallace")
        assertEquals(result?.get(0)?.teamA?.topPlayers?.get(0)?.jumperNumber, 9)
    }

    @Test
    fun forbiddenResponse() {
        result = null

        val errorBody = "forbidden"
        setupResponse(errorBody, HttpURLConnection.HTTP_FORBIDDEN)
        apiClient.getStatsList()
                .observeOn(Schedulers.computation())
                .doAfterTerminate { lock.countDown() }
                .subscribe(
                        { assertFalse(true)},
                        {
                            run {
                                assert(it is HttpException)
                                assertEquals((it as HttpException).code(), HttpURLConnection.HTTP_FORBIDDEN)
                                assertEquals(it.response().errorBody()?.string(), errorBody)
                                result = null
                            }
                        }
                )

        lock.await(WAITING, TimeUnit.MILLISECONDS)
        assertEquals(result, null)
    }
}
