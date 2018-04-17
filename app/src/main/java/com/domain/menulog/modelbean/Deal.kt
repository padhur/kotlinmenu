package com.domain.menulog.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by padhu.r on 17/4/18.
 */
data class Deal (
    @SerializedName("Description")
    @Expose
    private var description: String? = null,
    @SerializedName("DiscountPercent")
    @Expose
    private var discountPercent: String? = null,
    @SerializedName("QualifyingPrice")
    @Expose
    private var qualifyingPrice: String? = null
)