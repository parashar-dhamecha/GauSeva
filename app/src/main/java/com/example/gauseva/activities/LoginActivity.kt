package com.example.gauseva.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.gauseva.Api.RetrofitClient
import com.example.gauseva.Models.LoginResponse
import com.example.gauseva.R
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class LoginActivity : AppCompatActivity(), Serializable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
           hitLogin()
        }
        txtSignUpNow.setOnClickListener {
            startActivity(Intent(applicationContext, SignUpActivity::class.java))
        }

    }

    private fun hitLogin() {
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
//                            val jObj =  JSONObject(response.body()?.data.toString())
                        val userArray = response.body()?.data!!.toString()
                        Log.d("userarray", userArray)
                        val loginStatus: Int? = response.body()!!.data!!.status
                        if (response.isSuccessful) {
                            if (loginStatus == 1) {
                                val loginIntent =
                                    Intent(applicationContext, HomeActivity::class.java)
//     getString -- simple String                                 loginIntent.putExtra("UserArray", userArray)
                                loginIntent.putExtra("UserArray", userArray)
                                startActivity(loginIntent)
//                                    etEmail.setText("")
                            }

                        }
                    }
                })
        }
    }
     private class mLogin : AsyncTask<String, Void, String>{
         override fun doInBackground(vararg params: String?): String {
             TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
         }

     }


}


