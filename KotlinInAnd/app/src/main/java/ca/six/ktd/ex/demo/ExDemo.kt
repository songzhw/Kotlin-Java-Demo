package ca.six.ktd.ex.demo

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import ca.six.ktd.ex.does

class ExDemo : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sp = getSharedPreferences("sp_name", Context.MODE_PRIVATE)
        sp.does {
            putString("key", "value")
        }
        println("szw sp.key = ${sp.getString("key", "defaultValue")}")
    }
}