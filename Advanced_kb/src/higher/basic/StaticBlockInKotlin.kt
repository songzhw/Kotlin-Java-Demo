package higher.basic


/*
class StaticBlockInKotlin{
    {
        System.out.println("01");
    }
    static {
        System.out.println("02");
    }
    public A(){
        System.out.println("03");
    }
}
 */

class StaticBlockInKotlin {
    init {
        println("01")
    }

    init {
        println("03")
    }

    companion object {
        init {
            println("02")
        }
    }
}