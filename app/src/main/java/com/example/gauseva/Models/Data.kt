package com.example.gauseva.Models

//data class Data(
//    val name: String,
//    val username: String,
//    val email: String,
//    val phone: Int,
//    val date_of_birth: String,
//    val profile_picture: String,
//    val application_name: String,
//    val emergency_number: Int,
//    val token_type: String,
//    val access_token: String,
//    val expires_at: String,
//    val message: String,
//    val status: Int
//)
/////////////////
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("date_of_birth")
    @Expose
    var dateOfBirth: String? = null
    @SerializedName("profile_picture")
    @Expose
    var profilePicture: String? = null
    @SerializedName("application_name")
    @Expose
    var applicationName: String? = null
    @SerializedName("emergency_number")
    @Expose
    var emergencyNumber: String? = null
    @SerializedName("token_type")
    @Expose
    var tokenType: String? = null
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null
    @SerializedName("expires_at")
    @Expose
    var expiresAt: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("status")
    @Expose
    var status: Int? = null
}