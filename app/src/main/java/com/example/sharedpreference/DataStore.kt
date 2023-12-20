package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class DataStore(context: Context) {

    private var sharedPreference: SharedPreferences =
        context.getSharedPreferences("my_folder", Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = sharedPreference.edit()


    fun setUserName(name: String) {
        editor.putString("Name", name)
        editor.apply()
        editor.commit()
    }

    fun getName(): String? {
        return sharedPreference.getString("Name", null)
    }

    fun setAge(age: String) {
        editor.putString("Age", age)
        editor.apply()
        editor.commit()
    }

    fun getAge(): String? {
        return sharedPreference.getString("Age", null)
    }

}