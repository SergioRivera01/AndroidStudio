package com.sergiorivera.demo02

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("results")
    val users: List<UserResponse>
)

data class UserResponse(
    val email: String,
    val name: FullNameResponse,
    val picture: PictureResponse


)

data class FullNameResponse(
    val title: String,
    val first: String,
    val last: String
)

data class PictureResponse(
    var large: String,
    val medium: String,
    val thumbnail: String
)