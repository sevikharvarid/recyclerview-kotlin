package com.example.part2apps.data.remote.response

import android.os.Parcelable
import com.example.part2apps.data.model.Jokes
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiResponse(
    @SerializedName("result")
    var result: List<Jokes>

) : Parcelable{
    constructor(): this(mutableListOf())
}
