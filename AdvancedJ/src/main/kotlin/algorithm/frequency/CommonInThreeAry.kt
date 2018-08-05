package algorithm.frequency

// 求出下面三组中的公有的char字符. 输出要求不能有重复.
val chars = charArrayOf('a','h','c','f','e')
val str  = "bestfriendforever"
val list = arrayListOf<Char>('f','u','n','n','y','f')


fun main(args: Array<String>) {
    // Approach 1. for(for(for))自然是一个方法, 只是性能不好

    // Approach 2. 时间要从O(n3)要优化
    val tmp1 = HashSet<Char>()
    val tmp2 = HashSet<Char>()
    val commons = HashSet<Char>()

    for(char in chars){
        tmp1.add(char);
    }

    for(char in str.toCharArray()){
        if(tmp1.contains(char)){
            tmp2.add(char)
        }
    }

    for(char in list){
        if(tmp2.contains(char)){
            commons.add(char)
        }
    }


    println("set = $commons")

}