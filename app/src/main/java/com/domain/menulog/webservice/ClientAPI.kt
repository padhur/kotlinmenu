package com.domain.menulog.webservice

import com.domain.menulog.modelbean.Stats
import com.domain.menulog.network.Config
import com.domain.menulog.network.WebService
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