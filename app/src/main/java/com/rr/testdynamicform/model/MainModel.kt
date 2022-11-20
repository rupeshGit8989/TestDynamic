package com.rr.testdynamicform.model

import com.google.gson.annotations.SerializedName

data class MainModel(
        @SerializedName("form_name")
        val form_name: String,

        @SerializedName("form_fields")
        val form_fields: ArrayList<FormModel>,
)