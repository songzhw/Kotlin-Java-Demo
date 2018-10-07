package delegate.clazz

interface IBase {
    fun show()
}

class BaseImpl : IBase {
    override fun show() {
        println("szw BaseImpl show()")
    }
}

class Facade : IBase by BaseImpl() {
    fun display(){
        println("szw Facade display()")
    }
}

fun main(args: Array<String>) {
    val facade = Facade()
    facade.display()  //=> szw Facade display()
    facade.show()     //=> szw BaseImpl show()
}


/*
Delegation的实现机制:

反编译后就能看到Facade是如何实现的了:
public final class Facade implements IBase {
   private final BaseImpl $$delegate_0 = new BaseImpl();

   public final void display() {
      String var1 = "szw Facade display()";
      System.out.println(var1);
   }

   public void show() {
      this.$$delegate_0.show();
   }
}

 */
