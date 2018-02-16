package ca.six.kex

inline fun Sp.does(act : Sp.()->Unit){
    println("szw start does()")
    act(this)
    println("szw end does()")
}

/*
1. 为何声明是无参, 返回unit. 但save()可以用
2. 为何是无参, 这用act(this)
3.
 */