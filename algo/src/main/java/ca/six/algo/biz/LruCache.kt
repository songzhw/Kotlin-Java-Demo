package ca.six.algo.biz

class LruCache(val size: Int) {
    fun put(key: String, value: Int){

    }

    fun get(key:String){
    }
}

fun main() {
    val cache = LruCache(3)
    cache.put("one", 1)
    cache.put("II", 2)
    cache.put("三", 3)
    cache.get("one")  // 1变成最近刚使用过. 所以2成了最不常使用的元素
    cache.put("丁", 4) // 结果应该是3 1 4
}