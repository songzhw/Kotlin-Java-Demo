package ca.six.kex.generics

import ca.six.jold.generics.helper.Activity

inline fun <reified T> Activity.jump(){
    startActivity(this, T::class.java)
}