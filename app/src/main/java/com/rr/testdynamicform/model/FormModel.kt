package com.rr.testdynamicform.model

import com.google.gson.annotations.SerializedName

data class FormModel(
        @SerializedName("key")
        val key: String,

        @SerializedName("type")
        val type: String,

        @SerializedName("required")
        val required: Boolean,

        @SerializedName("templateOptions")
        val templateOptions: TemplateOption,

        )