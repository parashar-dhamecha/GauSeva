package com.example.gauseva.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.gauseva.R
import org.json.JSONArray

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val loginIntent = Intent()
        val jArray = loginIntent.getStringExtra("UserArray")
        Toast.makeText(applicationContext, "" + jArray, Toast.LENGTH_LONG).show()
    }
}
