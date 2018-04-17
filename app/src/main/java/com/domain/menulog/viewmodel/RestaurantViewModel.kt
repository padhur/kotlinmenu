package com.domain.menulog.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.domain.menulog.webservice.ClientAPI
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

/**
 * Created by padhu.r on 3/31/2018.
 */
class StatsViewModel(application: Application, private val apiClient: ClientAPI) : AndroidViewModel(application) {
    private var disposeBag = CompositeDisposable()
    val statsListLiveData = StatsLiveData()
    val loadingStatus = MutableLiveData<Boolean>()
    val errorStatus = MutableLiveData<Throwable>()

    init{
        loadStatsList()
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }

    fun loadStatsList()  = statsListLiveData
            .loadStatsList(apiClient::getStatsList, loadingStatus, errorStatus)
            .addTo(disposeBag)
}

class StatsViewModelFactory(val application: Application, val apiClient: ClientAPI) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StatsViewModel::class.java)) {
            return StatsViewModel(application, apiClient) as T
        } else {
            throw IllegalArgumentException("Must be of StatsViewModel")
        }
    }

}