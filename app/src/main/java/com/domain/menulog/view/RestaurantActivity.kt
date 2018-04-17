package com.domain.menulog.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.domain.menulog.R
import com.domain.menulog.viewmodel.StatsViewModel
import com.domain.menulog.viewmodel.StatsViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_stats.*
import javax.inject.Inject

class RestaurantActivity : AppCompatActivity(),
        HasSupportFragmentInjector
{
    private lateinit var statsFragment: ResultFragment

    private val tagStatsFragment = "RESTAURANT_FRAGMENT"

    @Inject
    protected lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    protected lateinit var statsViewModelFactory: StatsViewModelFactory

    private lateinit var statsViewModel: StatsViewModel

    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        setSupportActionBar(toolbar)
        toolbar.title = title

        statsViewModel = ViewModelProviders.of(this@RestaurantActivity, statsViewModelFactory).get(StatsViewModel::class.java)

        if(savedInstanceState == null) {
            statsFragment = ResultFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.stats_list_container, statsFragment, tagStatsFragment)
                    .commit()
        } else {
            statsFragment = supportFragmentManager.findFragmentByTag(tagStatsFragment) as ResultFragment
        }
    }
}
