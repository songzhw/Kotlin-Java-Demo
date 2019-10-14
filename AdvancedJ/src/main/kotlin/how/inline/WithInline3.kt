package how.inline


inline fun foo4(noinline action: (num: Int) -> Unit) {
    println("001")
    action(23)
    println("003")
}

fun main() {
    foo4 {
        val ret = it + 1
        println("inside lambda : $ret")
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