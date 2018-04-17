package com.domain.menulog.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.domain.menulog.modelbean.Stats
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by padhu.r on 3/31/2018.
 */
data class MappedStatsList(
        val statsList: List<Stats>
)

class StatsLiveData : LiveData<MappedStatsList>() {
    fun loadStatsList(getStatsListApi: () -> Single<List<Stats>>,
                      loadingStatus: MutableLiveData<Boolean>,
                      errorStatus: MutableLiveData<Throwable>): Disposable {
        return getStatsListApi().doOnSubscribe {
            loadingStatus.postValue(true) }
                .doAfterTerminate {
                    loadingStatus.postValue(false) }
                .observeOn(Schedulers.computation())
                .map { MappedStatsList(it) }
                .subscribe(
                        { postValue(it) },
                        { errorStatus.postValue(it) }
                )
    }
}