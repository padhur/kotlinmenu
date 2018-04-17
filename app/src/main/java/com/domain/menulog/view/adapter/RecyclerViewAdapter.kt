package com.domain.menulog.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.DecodeFormat
import com.domain.menulog.modelbean.Stats
import com.domain.menulog.R
import com.domain.menulog.app.GlideApp
import com.domain.menulog.network.Config
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.android.synthetic.main.stat_item.view.*
import kotlinx.android.synthetic.main.stats_list_item.view.*
import kotlinx.android.synthetic.main.top_players_layout.view.*

class RecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var statsList: List<Stats> = arrayListOf()
    private var count: Int = 0;

    fun setStatsList(list : List<Stats?>) {
        statsList = list.filterNotNull()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stats_list_item, parent, false)
        var size: Int = statsList.get(count).teamA?.topPlayers?.size!!-1
        count++;
        return ViewHolder(view,size,LayoutInflater.from(parent.context))
    }

    override fun getItemCount(): Int {
        return statsList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item = statsList.get(position)
        holder.mView.tv_parentName.setText(statsList.get(position).statType)
        for(i in 0..statsList.get(position).teamA?.topPlayers!!.size-1) {
            val top_player: String = context.resources.getString(R.string.top_player) + " "+ (i+1)
            holder.mView.stats_detail_layout.getChildAt(i).tv_top_player.setText(top_player)
            var url: String = Config.playerImage +statsList.get(position).teamA?.topPlayers?.get(i)?.id + Config.fileextension
            GlideApp.with(holder.mView.context)
                    .load(url)
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .placeholder(R.drawable.headshot_blank_large)
                    .centerInside()
                    .into(holder.mView.stats_detail_layout.getChildAt(i).teamA_layout.profile_image.img_profile_image)
            holder.mView.stats_detail_layout.getChildAt(i).teamA_layout.short_name_layout.tv_value.setText(statsList.get(position).teamA?.topPlayers?.get(i)?.shortName)
            holder.mView.stats_detail_layout.getChildAt(i).teamA_layout.short_name_layout.tv_description.setText(R.string.short_name)
            holder.mView.stats_detail_layout.getChildAt(i).teamA_layout.jumper_number_layout.tv_value.setText(statsList.get(position).teamA?.topPlayers?.get(i)?.jumperNumber.toString())
            holder.mView.stats_detail_layout.getChildAt(i).teamA_layout.jumper_number_layout.tv_description.setText(R.string.jumper_numer)
            holder.mView.stats_detail_layout.getChildAt(i).teamA_layout.position_layout.tv_value.setText(statsList.get(position).teamA?.topPlayers?.get(i)?.position)
            holder.mView.stats_detail_layout.getChildAt(i).teamA_layout.position_layout.tv_description.setText(R.string.position)
            holder.mView.stats_detail_layout.getChildAt(i).teamA_layout.stat_layout.tv_value.setText(statsList.get(position).teamA?.topPlayers?.get(i)?.statValue.toString())
            holder.mView.stats_detail_layout.getChildAt(i).teamA_layout.stat_layout.tv_description.setText(R.string.stat_value)

            url = Config.playerImage + statsList.get(position).teamB?.topPlayers?.get(i)?.id + Config.fileextension
            GlideApp.with(holder.mView.context)
                    .load(url)
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .placeholder(R.drawable.headshot_blank_large)
                    .centerInside()
                    .into(holder.mView.stats_detail_layout.getChildAt(i).teamB_layout.profile_image.img_profile_image)

            holder.mView.stats_detail_layout.getChildAt(i).teamB_layout.short_name_layout.tv_value.setText(statsList.get(position).teamB?.topPlayers?.get(i)?.shortName)
            holder.mView.stats_detail_layout.getChildAt(i).teamB_layout.short_name_layout.tv_description.setText(R.string.short_name)
            holder.mView.stats_detail_layout.getChildAt(i).teamB_layout.jumper_number_layout.tv_value.setText(statsList.get(position).teamB?.topPlayers?.get(i)?.jumperNumber.toString())
            holder.mView.stats_detail_layout.getChildAt(i).teamB_layout.jumper_number_layout.tv_description.setText(R.string.jumper_numer)
            holder.mView.stats_detail_layout.getChildAt(i).teamB_layout.position_layout.tv_value.setText(statsList.get(position).teamB?.topPlayers?.get(i)?.position)
            holder.mView.stats_detail_layout.getChildAt(i).teamB_layout.position_layout.tv_description.setText(R.string.position)
            holder.mView.stats_detail_layout.getChildAt(i).teamB_layout.stat_layout.tv_value.setText(statsList.get(position).teamB?.topPlayers?.get(i)?.statValue.toString())
            holder.mView.stats_detail_layout.getChildAt(i).teamB_layout.stat_layout.tv_description.setText(R.string.stat_value)
        }

        holder.mView.setOnClickListener {
            if(holder.mView.stats_detail_layout.visibility.equals(View.VISIBLE))
                holder.mView.stats_detail_layout.visibility = View.GONE
            else
                holder.mView.stats_detail_layout.visibility = View.VISIBLE
        }
    }

    class ViewHolder(val mView: View, val size: Int, val inflater: LayoutInflater) : RecyclerView.ViewHolder(mView) {
        var item: Stats? = null

        init {
            for(i in 0..size) {
                var v: View = inflater.inflate(R.layout.top_players_layout,null)
                mView.stats_detail_layout.addView(v,i)
            }
        }
        override fun toString(): String {
            return super.toString() + " '" + item?.matchId + "'"
        }
    }
}