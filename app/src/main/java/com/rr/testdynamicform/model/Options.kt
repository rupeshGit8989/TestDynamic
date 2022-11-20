package com.rr.testdynamicform.model

import com.google.gson.annotations.SerializedName

data class Options(
        @SerializedName("label")
        val label: String,

        @SerializedName("value")
        val value: String,

        var isCheck: Boolean = false,
)