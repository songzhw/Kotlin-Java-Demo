inline fun foo(arg: Int){
    println("001")
    arg + 1
    println("003")
}

fun main() {
    foo(23)
}

/*
编译后:

public static final void foo(int arg) {
   System.out.println("001");
   int var10000 = arg + 1;
   System.out.println("003");
}

public static final void main() {
   foo(23);
}
 */