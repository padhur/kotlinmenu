package com.domain.stats.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by padhu.r on 17/4/18.
 */
data class Results(
    @SerializedName("Results")
    @Expose
    private var restaurants: List<Restaurant>? = null,
    @SerializedName("ShortResultText")
    @Expose
    private var shortResultText: String? = null,
    @SerializedName("Area")
    @Expose
    private var area: String? = null,
    @SerializedName("Errors")
    @Expose
    private var errors: List<Any>? = null,
    @SerializedName("HasErrors")
    @Expose
    private var hasErrors: Boolean? = null,
    @SerializedName("MetaData")
    @Expose
    private var metaData: MetaData? = null
)