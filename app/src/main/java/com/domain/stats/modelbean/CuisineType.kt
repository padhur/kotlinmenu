package com.domain.stats.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by padhu.r on 17/4/18.
 */
data class CuisineType (
    @SerializedName("Id")
    @Expose
    private var id: Int? = null,
    @SerializedName("Name")
    @Expose
    private var name: String? = null,
    @SerializedName("SeoName")
    @Expose
    private var seoName: String? = null
)
