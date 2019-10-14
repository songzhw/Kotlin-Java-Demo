package how.inline


inline fun foo2(arg: Int) {
    println("001")
    arg + 1
    println("003")
}

fun main() {
    foo2(23)
}

/*
public final class WithoutInlineKt {
    public static final void foo(int arg) {
       System.out.println("001");
       int var10000 = arg + 1;
       System.out.println("003");
    }

    public static final void main() {
       System.out.println("001");
       int var10000 = 23 + 1;
       System.out.println("003");
    }
}
 */