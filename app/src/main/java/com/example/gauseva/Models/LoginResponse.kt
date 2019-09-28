package com.example.gauseva.Models

//data class LoginResponse (val user: User)

////////

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("data")
    @Expose
    var user: User? = null
}
