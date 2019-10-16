package how.inline

// it seems the crossinline和不加任何修饰符(即inline了)是一样的
inline fun foo4(noinline action: (num: Int) -> Unit, crossinline  job: (id: Int) -> Unit) {
    println("001")
    action(23)
    job(300)
    println("003")

}

fun main() {
    foo4 ({
        val ret = it + 1
        println("inside inline : $ret")
    }) {
        val ret = it + 100
        println("inside inline 02 : $ret")
    }
}

/*
编译后
public static final void main() {
   System.out.println("001");
   int it = 23;
   int ret = it + 1;
   System.out.println("inside lambda : " + ret);
   System.out.println("003");
}
 */