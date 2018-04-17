package com.domain.stats.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.domain.stats.modelbean.Stats
import com.domain.stats.R
import com.domain.stats.view.adapter.RecyclerViewAdapter
import com.domain.stats.viewmodel.MappedStatsList
import com.domain.stats.viewmodel.StatsViewModel
import com.domain.stats.viewmodel.StatsViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_stats.view.*
import javax.inject.Inject

/**
 * A fragment representing a stats list of Items.
 */
class StatsFragment : Fragment() {
    private lateinit var adapter: RecyclerViewAdapter

    @Inject
    protected lateinit var statsViewModelFactory: StatsViewModelFactory

    private lateinit var statsViewModel: StatsViewModel

    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_stats, container, false)

        val context = rootView.getContext()
        rootView.stats_list.layoutManager = LinearLayoutManager(context)
        adapter = RecyclerViewAdapter(getContext()!!)
        rootView.stats_list.adapter = adapter;
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        statsViewModel = ViewModelProviders.of(activity!!, statsViewModelFactory).get(StatsViewModel::class.java)
        setupView()
    }

    private fun showMessage(message: String) {
        rootView.stats_list.visibility = View.GONE
        rootView.message.text = message
        rootView.message.visibility = View.VISIBLE
    }

    private fun showStatsList(it: List<Stats?>) {
        adapter.setStatsList(it)
    }

    private fun setupView() {
        statsViewModel.statsListLiveData.observe(this, Observer<MappedStatsList> {
            it?.statsList?.let {
                showStatsList(it)
            }
        })

        statsViewModel.loadingStatus.observe(this, Observer<Boolean> {
            isLoading ->
            if(isLoading == true)
                rootView.progressBar.visibility = View.VISIBLE
            else
                rootView.progressBar.visibility = View.GONE
        })

        statsViewModel.errorStatus.observe(this, Observer<Throwable> {
            showMessage(getString(R.string.could_not_load_stats_data))
        })
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {

        fun newInstance(): StatsFragment {
            return StatsFragment()
        }
    }
}
