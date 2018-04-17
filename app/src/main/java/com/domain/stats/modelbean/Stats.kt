package com.domain.stats.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Padhu.r on 3/31/2018.
 */
data class Stats(
    @SerializedName("match_id")
    @Expose
    var matchId: String? = null,
    @SerializedName("team_A")
    @Expose
    var teamA: Team? = null,
    @SerializedName("team_B")
    @Expose
    var teamB: Team? = null,
    @SerializedName("stat_type")
    @Expose
    var statType: String? = null
)