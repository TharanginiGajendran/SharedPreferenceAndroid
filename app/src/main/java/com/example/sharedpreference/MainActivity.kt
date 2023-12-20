package com.example.sharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var userAge: EditText


    private lateinit var dataStorage : DataStore



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.etName)
        userAge = findViewById(R.id.etAge)

        dataStorage = DataStore(this)

        viewListeners()

    }

    override fun onPause() {
//        to save value
        super.onPause()
        viewListeners()
    }

    override fun onResume() {
        //to display saved value
        super.onResume()
        viewListeners()
    }

    private fun viewListeners() {
        //store value
        val name  = userName.text.toString()
        if (name != "")
        dataStorage.setUserName(name)

        val age = userAge.text.toString()
        if (age != "")
        dataStorage.setAge(age)

        //display value
        userName.setText(dataStorage.getName())

        userAge.setText(dataStorage.getAge())
    }

}