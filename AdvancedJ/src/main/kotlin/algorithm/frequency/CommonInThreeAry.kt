package algorithm.frequency

// 求出下面三组中的公有的char字符. 输出要求不能有重复.
val chars = charArrayOf('a','h','c','f','e')
val str  = "bestfriendforever"
val list = arrayListOf<Char>('f','u','n','n','y','f')


fun main(args: Array<String>) {
    // Approach 1. for(for(for))自然是一个方法, 只是性能不好

    // Approach 2. 时间要从O(n3)要优化
    var commons = HashSet<Char>()

    for(char in chars){
        commons.add(char);
    }

    for(char in str.toCharArray()){
        if(!commons.contains(char)){
            println("remove $char")
            commons.remove(char)
            println("    set-> $commons")
        }
    }

    println("set = $commons")

}