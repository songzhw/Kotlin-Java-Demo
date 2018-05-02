package ca.six.issues.abstractclz

abstract class MyAbstractClass(val id: Int) {

    fun foo(){
        println("MyAbstractClass foo($id)")
        bar()
    }

    protected abstract fun bar()
}