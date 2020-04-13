package com.rahul.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {
    var titleName: String? = "Avengers"
    lateinit var btnLogOut: Button

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_avengers)

        titleName = sharedPreferences.getString("Title", "The Avengers")

        title=titleName

        btnLogOut = findViewById(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            val intent = Intent(this@AvengersActivity,LoginActivity::class.java)
            sharedPreferences.edit().clear().apply()
            startActivity(intent)
        }
    }

}
