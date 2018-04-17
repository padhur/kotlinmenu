package com.domain.stats.network

import com.domain.stats.modelbean.Stats
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by padhu.r on 3/31/2018.
 */
interface WebService {
    @GET
    fun getStats(@Url url: String) : Single<List<Stats>>
}