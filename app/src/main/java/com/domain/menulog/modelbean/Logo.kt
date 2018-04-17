package com.domain.menulog.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by padhu.r on 17/4/18.
 */
data class Logo (
    @SerializedName("StandardResolutionURL")
    @Expose
    private val standardResolutionURL: String? = null
)