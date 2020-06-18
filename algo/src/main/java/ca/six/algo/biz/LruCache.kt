package ca.six.algo.biz

import java.util.*
import kotlin.collections.HashMap

class LruCache(val size: Int) {
    // map结构保证put与get全是O(1)
    private val map = HashMap<String, Int>()

    // double linked list用来保存"顺序". 双链表(而非单链表)是为了保证删除时时间为O(1)
    private val list = LinkedList<String>()

    fun put(key: String, value: Int) {
        // TODO what if key exists already
        map.put(key, value)
        list.add(key)
    }

    fun get(key: String) :Int? {
        // TODO what if the key is not existing?
        return map.get(key)
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