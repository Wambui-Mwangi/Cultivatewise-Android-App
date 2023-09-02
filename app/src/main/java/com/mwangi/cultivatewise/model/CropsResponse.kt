package com.mwangi.cultivatewise.model

import com.google.gson.annotations.SerializedName

data class CropsResponse(
    var crops: List<CropsRequest>,
    var name: String,
    var category: String,
    var description: String,
    var image: String,
    @SerializedName("ideal_climate") var idealClimate: String,
    @SerializedName("water_requirements") var waterRequirements: String,
    @SerializedName("soil_type") var soilType: String,
    @SerializedName("growth_duration") var growthDuration: String
)
