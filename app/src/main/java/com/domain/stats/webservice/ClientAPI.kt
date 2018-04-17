package com.domain.stats.webservice

import com.domain.stats.modelbean.Stats
import com.domain.stats.network.Config
import com.domain.stats.network.WebService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by padhu.r on 3/31/2018.
 */
class ClientAPI(private val apiService : WebService) {
    fun getStatsList() : Single<List<Stats>> {
        return apiService.getStats(Config.statsUrl)
                .subscribeOn(Schedulers.io())
    }
}