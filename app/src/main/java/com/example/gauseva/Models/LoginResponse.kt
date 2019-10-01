package com.example.gauseva.Models

//data class LoginResponse (val data: Data)

////////

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("data")
    @Expose
    var data: Data? = null
}
