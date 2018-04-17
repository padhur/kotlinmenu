package com.domain.menulog.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Padhu.r on 3/31/2018.
 */
data class Team(
        @SerializedName("id")
        @Expose
        var id: Int? = null,
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("code")
        @Expose
        var code: String? = null,
        @SerializedName("short_name")
        @Expose
        var shortName: String? = null,
        @SerializedName("top_players")
        @Expose
        var topPlayers: List<TopPlayer>? = null
)