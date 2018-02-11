package ca.six.kex

inline fun Sp.does(act : Sp.()->Unit){
    println("szw start does()")
    act(this)
    println("szw end does()")
}