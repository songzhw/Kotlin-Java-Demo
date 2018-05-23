package ca.six.kex.generics

import ca.six.jold.generics.helper.Activity
import ca.six.jold.generics.helper.SettingActivity

class Home222Activity : Activity() {

    fun click01(){
        startActivity(this, SettingActivity::class.java)
    }

    fun click02(){

    }

}