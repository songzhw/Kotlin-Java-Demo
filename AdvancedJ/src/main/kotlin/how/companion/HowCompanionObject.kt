package how.companion

// 并不是编译成static. 而是用了static inner class
class A {
    companion object {
        fun of(){}
    }
}

fun main(args: Array<String>) {
    A.of()
}

/*
    ==> 编译成java
public final class A {
   public static final A.Companion Companion = new A.Companion((DefaultConstructorMarker)null);

   public static final class Companion {
      public final void of() {}
      private Companion() {}
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

public final class HowCompanionObjectKt {
   public static final void main(@NotNull String[] args) {
      A.Companion.of();
   }
}
*/