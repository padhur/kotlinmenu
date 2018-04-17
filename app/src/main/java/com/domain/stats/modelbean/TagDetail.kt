package com.domain.stats.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by padhu.r on 17/4/18.
 */
data class TagDetail (
    @SerializedName("Key")
    @Expose
    private val key: String? = null,
    @SerializedName("DisplayName")
    @Expose
    private val displayName: String? = null,
    @SerializedName("Colour")
    @Expose
    private val colour: String? = null,
    @SerializedName("BackgroundColour")
    @Expose
    private val backgroundColour: String? = null,
    @SerializedName("Priority")
    @Expose
    private val priority: Int? = null
)