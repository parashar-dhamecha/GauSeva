package com.example.gauseva.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.gauseva.Api.RetrofitClient
import com.example.gauseva.Models.LoginResponse
import com.example.gauseva.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnSignUp.setOnClickListener {
            val first_name: String = etFname.text.toString().trim()
            val last_name: String = etLname.text.toString().trim()
            val email: String = etEmail.text.toString().trim()
            val phone: String = etPhone.text.toString().trim()

            if (first_name.isEmpty()) {
                etFname.error = "Enter First Name"
                etFname.requestFocus()
            } else if (last_name.isEmpty()) {
                etLname.error = "Enter Last Name"
                etLname.requestFocus()
            } else if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Enter Valid Email "
                etEmail.requestFocus()
            } else if (phone.isEmpty() || phone.length < 10) {
                etPhone.error = "Enter Valid Phone "
                etPhone.requestFocus()
            } else {
                RetrofitClient.instance.register(first_name, last_name, email, phone)
                    .enqueue(object : Callback<LoginResponse> {
                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            Toast.makeText(
                                applicationContext,
                                "Failed Registration",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }

                        override fun onResponse(
                            call: Call<LoginResponse>,
                            response: Response<LoginResponse>
                        ) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    applicationContext,
                                    "Registered Successfully" ,
                                    Toast.LENGTH_SHORT
                                ).show()
//                                startActivity(Intent(applicationContext, HomeActivity::class.java))
//                                etFname.setText("")
//                                etLname.setText("")
//                                etEmail.setText("")
//                                etPhone.setText("")
                            }
                        }
                    })
            }
        }

        txtLogin.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        }
    }
}
