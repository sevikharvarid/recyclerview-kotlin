package com.example.part2apps.data.remote.response

import android.os.Parcelable
import com.example.part2apps.data.model.Jokes
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class ApiResponse(

    @SerializedName("result")
    val results: @RawValue List<Jokes>,
    @SerializedName("total")
    val total: Int

) : Parcelable{
    constructor(): this(mutableListOf(),0)
}



