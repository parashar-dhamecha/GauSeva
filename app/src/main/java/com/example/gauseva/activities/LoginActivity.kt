package com.example.gauseva.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.gauseva.Api.RetrofitClient
import com.example.gauseva.Models.LoginResponse
import com.example.gauseva.R
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val email: String = etEmail.text.toString().trim()
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Enter Valid Email"
                etEmail.requestFocus()
            } else {
                RetrofitClient.instance.login(email)
                    .enqueue(object : Callback<LoginResponse> {
                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, "API Failure", Toast.LENGTH_LONG)
                                .show()
                        }

                        override fun onResponse(
                            call: Call<LoginResponse>,
                            response: Response<LoginResponse>
                        ) {
//                            val jArray:
                            val loginStatus: Int? = response.body()?.user?.status
                            val userArray = response.body()?.user.toString()
                            if (response.isSuccessful) {
                                if (loginStatus == 1) {
                                    val loginIntent =
                                        Intent(applicationContext, HomeActivity::class.java)
                                    loginIntent.putExtra(
                                        "UserArray", userArray
                                    )
                                    startActivity(loginIntent)
                                    etEmail.setText("")
                                }
                            }
                        }
                    })
            }
        }
        txtSignUpNow.setOnClickListener {
            startActivity(Intent(applicationContext, SignUpActivity::class.java))
        }

    }
}


