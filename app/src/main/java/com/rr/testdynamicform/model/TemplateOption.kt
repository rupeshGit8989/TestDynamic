package com.rr.testdynamicform.model

import com.google.gson.annotations.SerializedName

data class TemplateOption(
        @SerializedName("label")
        val label: String,

        @SerializedName("hideFieldUnderline")
        val hideFieldUnderline: Boolean,

        @SerializedName("appearance")
        val appearance: Boolean,

        @SerializedName("options")
        val options: ArrayList<Options>,

        )