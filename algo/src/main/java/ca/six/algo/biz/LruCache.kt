package ca.six.algo.biz

import java.util.*
import kotlin.collections.HashMap

class LruCache(val size: Int) {
    // map结构保证put与get全是O(1)
    private val map = HashMap<String, Int>()

    // double linked list用来保存"顺序". 双链表(而非单链表)是为了保证删除时时间为O(1)
    private val list = LinkedList<String>()


    fun put(key: String, value: Int) {
        val cachedSize = map.size
        println("    put() : cachedSize = $cachedSize, listSize = ${list.size}")

        // 缓存已经到达上限, 要删除最不常用的元素,才能再添加新元素
        if (cachedSize == size) {
            val toBeDeletedKey = list.poll()
            map.remove(toBeDeletedKey)
        }

        // 若本来key就不在, 就直接存值
        if (get(key) == null) {
            map.put(key, value)
            list.add(key)
        } //若本来key就已经存在, 那我们只要调整顺序(get()已做到了), 不用添加数据
    }

    fun get(key: String): Int? {
        val ret = map.get(key)
        if (ret != null) {
            list.remove(key)
            list.add(key)  // add to the end
        }
        return ret
    }

    override fun toString(): String {
        return list.toString()
    }
}

fun main() {
    var cache = LruCache(3)
    cache.put("one", 1)
    cache.put("II", 2)
    cache.put("三", 3)
    println("1 : $cache")  //=> [one, II, 三]

    cache.get("one")  // 1变成最近刚使用过. 所以2成了最不常使用的元素
    println("2 : $cache")  //=> [II, 三, one]

    cache.put("丁", 4)
    println("3 : $cache") //=> [三, one, 丁]

    cache.get("三")
    println("4 : $cache") //=> [one, 丁, 三]

    cache.put("V", 5)
    cache.put("VI", 6)
    println("5 : $cache") //=> [三, V, VI]


    // ===================
    cache = LruCache(2)
    cache.put("one", 1)
    cache.put("II", 2)
    println("==================================\n")
    println("1. $cache") //=> [one, II]

    cache.put("one", 11)
    println("2. $cache") //=> [II, one]

    cache.put("3", 3)
    println("3. $cache") //=> [one, 3]

    cache.put("4", 4)
    println("4. $cache") //=> [3, 4]
}