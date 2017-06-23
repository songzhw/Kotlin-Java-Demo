interface IBase {
    fun print()
    fun add(a: Int, b: Int): Int
}

class Base(val x: Int) : IBase {
    override fun add(a: Int, b: Int): Int {
        return a + b;
    }

    override fun print() {
        print(x)
    }
}

// only interfaces can be delegated to
class Derived(b: IBase) : IBase by b

fun main(args: Array<String>) {
    val b = Base(30)
    Derived(b).print() //=> 30    println(Derived(b).add(1, 2)) //=> 3
}

/*
How kotlin do it?
:
class Derived(b : IBase){
    fun add(a, b){
        b.add(a,b)
    }
    fun print(){
        b.print()
    }
}
 */