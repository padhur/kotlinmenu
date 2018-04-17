package com.domain.menulog.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by padhu.r on 17/4/18.
 */
data class SearchedTerms (
    @SerializedName("Phrase")
    @Expose
    private val phrase: Any? = null,
    @SerializedName("Postcode")
    @Expose
    private val postcode: Any? = null,
    @SerializedName("Cuisine")
    @Expose
    private val cuisine: Any? = null,
    @SerializedName("CuisineSeoName")
    @Expose
    private val cuisineSeoName: Any? = null,
    @SerializedName("City")
    @Expose
    private val city: Any? = null
)