package com.domain.stats.modelbean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by padhu.r on 17/4/18.
 */
data class Restaurant (
    @SerializedName("Badges")
    @Expose
    private val badges: List<Any>? = null,
    @SerializedName("Score")
    @Expose
    private val score: Int? = null,
    @SerializedName("DriveDistance")
    @Expose
    private val driveDistance: Int? = null,
    @SerializedName("DriveInfoCalculated")
    @Expose
    private val driveInfoCalculated: Boolean? = null,
    @SerializedName("NewnessDate")
    @Expose
    private val newnessDate: String? = null,
    @SerializedName("DeliveryMenuId")
    @Expose
    private val deliveryMenuId: Any? = null,
    @SerializedName("DeliveryOpeningTime")
    @Expose
    private val deliveryOpeningTime: Any? = null,
    @SerializedName("DeliveryCost")
    @Expose
    private val deliveryCost: Int? = null,
    @SerializedName("MinimumDeliveryValue")
    @Expose
    private val minimumDeliveryValue: Int? = null,
    @SerializedName("DeliveryTimeMinutes")
    @Expose
    private val deliveryTimeMinutes: Any? = null,
    @SerializedName("DeliveryWorkingTimeMinutes")
    @Expose
    private val deliveryWorkingTimeMinutes: Any? = null,
    @SerializedName("OpeningTime")
    @Expose
    private val openingTime: String? = null,
    @SerializedName("OpeningTimeIso")
    @Expose
    private val openingTimeIso: String? = null,
    @SerializedName("SendsOnItsWayNotifications")
    @Expose
    private val sendsOnItsWayNotifications: Boolean? = null,
    @SerializedName("RatingAverage")
    @Expose
    private val ratingAverage: Double? = null,
    @SerializedName("Latitude")
    @Expose
    private val latitude: Double? = null,
    @SerializedName("Longitude")
    @Expose
    private val longitude: Double? = null,
    @SerializedName("Tags")
    @Expose
    private val tags: List<Any>? = null,
    @SerializedName("ScoreMetadata")
    @Expose
    private val scoreMetadata: Any? = null,
    @SerializedName("Id")
    @Expose
    private val id: Int? = null,
    @SerializedName("Name")
    @Expose
    private val name: String? = null,
    @SerializedName("Address")
    @Expose
    private val address: String? = null,
    @SerializedName("Postcode")
    @Expose
    private val postcode: String? = null,
    @SerializedName("City")
    @Expose
    private val city: String? = null,
    @SerializedName("CuisineTypes")
    @Expose
    private val cuisineTypes: List<CuisineType>? = null,
    @SerializedName("Url")
    @Expose
    private val url: String? = null,
    @SerializedName("IsOpenNow")
    @Expose
    private val isOpenNow: Boolean? = null,
    @SerializedName("IsPremier")
    @Expose
    private val isPremier: Boolean? = null,
    @SerializedName("IsSponsored")
    @Expose
    private val isSponsored: Boolean? = null,
    @SerializedName("IsTemporaryBoost")
    @Expose
    private val isTemporaryBoost: Boolean? = null,
    @SerializedName("SponsoredPosition")
    @Expose
    private val sponsoredPosition: Int? = null,
    @SerializedName("IsNew")
    @Expose
    private val isNew: Boolean? = null,
    @SerializedName("IsTemporarilyOffline")
    @Expose
    private val isTemporarilyOffline: Boolean? = null,
    @SerializedName("ReasonWhyTemporarilyOffline")
    @Expose
    private val reasonWhyTemporarilyOffline: String? = null,
    @SerializedName("UniqueName")
    @Expose
    private val uniqueName: String? = null,
    @SerializedName("IsCloseBy")
    @Expose
    private val isCloseBy: Boolean? = null,
    @SerializedName("IsHalal")
    @Expose
    private val isHalal: Boolean? = null,
    @SerializedName("IsTestRestaurant")
    @Expose
    private val isTestRestaurant: Boolean? = null,
    @SerializedName("DefaultDisplayRank")
    @Expose
    private val defaultDisplayRank: Int? = null,
    @SerializedName("IsOpenNowForDelivery")
    @Expose
    private val isOpenNowForDelivery: Boolean? = null,
    @SerializedName("IsOpenNowForCollection")
    @Expose
    private val isOpenNowForCollection: Boolean? = null,
    @SerializedName("RatingStars")
    @Expose
    private val ratingStars: Double? = null,
    @SerializedName("Logo")
    @Expose
    private val logo: List<Logo>? = null,
    @SerializedName("Deals")
    @Expose
    private val deals: List<Deal>? = null,
    @SerializedName("NumberOfRatings")
    @Expose
    private val numberOfRatings: Int? = null,
    @SerializedName("ShowSmiley")
    @Expose
    private val showSmiley: Boolean? = null,
    @SerializedName("SmileyResult")
    @Expose
    private val smileyResult: Int? = null,
    @SerializedName("SmileyUrl")
    @Expose
    private val smileyUrl: String? = null,
    @SerializedName("SmileyElite")
    @Expose
    private val smileyElite: String? = null
)