package com.hugl.sleepapp.model

import com.squareup.moshi.Json

data class Test(
    @Json(name = "contentType")
                val contentType: String?,
    @Json(name = "_id")
    val id: String?,
    @Json(name = "filename")
    val name: String?
)
