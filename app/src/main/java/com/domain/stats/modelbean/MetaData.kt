package com.domain.stats.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by padhu.r on 17/4/18.
 */
class MetaData (
    @SerializedName("SearchedTerms")
    @Expose
    private val searchedTerms: SearchedTerms? = null,
    @SerializedName("TagDetails")
    @Expose
    private val tagDetails: List<TagDetail>? = null
)