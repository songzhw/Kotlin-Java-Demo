package how.inline


fun foo1(arg: Int){
    println("001")
    arg + 1
    println("003")
}

fun main() {
    foo1(23)
}

/*
public final class WithoutInlineKt {
    public static final void foo1(int arg) {
       System.out.println("001");
       int var10000 = arg + 1;
       System.out.println("003");
    }

    public static final void main() {
       foo1(23);
    }
}
 */