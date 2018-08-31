package how.companion

class MyClass {
    private constructor() {
        println("szw MyClass private constructor")
    }
    companion object Factory{
        fun create(): MyClass = MyClass()
    }
}

fun main(args: Array<String>) {
//    val obj = MyClass()
    val obj = MyClass.create()
}

/*
转成了:


public final class MyClass {
   public static final MyClass.Factory Factory = new MyClass.Factory((DefaultConstructorMarker)null);

   private MyClass() {
      String var1 = "szw MyClass private constructor";
      System.out.println(var1);
   }

   // $FF: synthetic method
   public MyClass(DefaultConstructorMarker $constructor_marker) {
      this();
   }

   public static final class Factory {
      @NotNull
      public final MyClass create() {
         return new MyClass((DefaultConstructorMarker)null);
      }
      private Factory() {   }
      public Factory(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
public final class CompanionTwoKt {
   public static final void main(@NotNull String[] args) {
      MyClass obj = MyClass.Factory.create();
   }
}

 */