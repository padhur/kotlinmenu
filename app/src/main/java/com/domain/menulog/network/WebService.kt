package com.domain.menulog.network

import com.domain.menulog.modelbean.Stats
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Created by padhu.r on 3/31/2018.
 */
interface WebService {
    @GET
    fun getStats(@Url url: String) : Single<List<Stats>>
    @GET
    fun getRestaurantResults(@Query ("restaurants") searchkey: String )
}