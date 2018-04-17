package com.domain.menulog.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Padhu.r on 3/31/2018.
 */
data class TopPlayer(
        @SerializedName("id")
        @Expose
        var id: Int? = null,
        @SerializedName("position")
        @Expose
        var position: String? = null,
        @SerializedName("full_name")
        @Expose
        var fullName: String? = null,
        @SerializedName("short_name")
        @Expose
        var shortName: String? = null,
        @SerializedName("stat_value")
        @Expose
        var statValue: Int? = null,
        @SerializedName("jumper_number")
        @Expose
        var jumperNumber: Int? = null
)
