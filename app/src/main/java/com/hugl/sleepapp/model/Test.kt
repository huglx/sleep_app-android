package com.hugl.sleepapp.model

import com.squareup.moshi.Json

data class Test(@Json(name = "contentType")
                val contentType: String?)
