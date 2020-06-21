// 这题太难了, 算了吧, 不用复习了

package ca.six.algo.recurse


import java.util.*

/*
 下面是两个2x3滑动拼图(用二维数组表示), 其中的0是代表着空的那个格子. 要求移动格子, 让board变成[[1,2,3], [4,5,0]]就胜利了.
 现在要求一个算法, 给定一个board, 求服务生需要的最少移动次数. 如不能胜利, 返回-1.

 比如说, board = [ [4,1,2], [5,0,3] ]
 4 1 2    4 1 2    0 1 2    1 0 2    1 2 0    1 2 3
 5 0 3 => 0 5 3 => 4 5 3 => 4 5 3 => 4 5 3 => 4 5 0
 所以是移动5次, 算法要返回5.
 */

fun 华容道(board: String): Int {
    var target = "123450"
    // 我们要逆推, 从target推到board, 这样就要把target变成有上下左右邻居的二维容器,
    // 这个neighbor就是此用, 它是[0,1,2], [3,4,5]排列中的每个元素的邻居
    val neighbor = arrayOf(
        arrayOf(1, 3),
        arrayOf(0, 4, 2),
        arrayOf(1, 5),
        arrayOf(0, 4),
        arrayOf(3, 1, 5),
        arrayOf(4, 2)
    )
    val row = 2
    val column = 3

    val queue = LinkedList<String>()
    val visited = HashSet<String>()
    queue.offer(board)
    visited.add(board)

    var step = 0
    while (!queue.isEmpty()) {
        val queueSize = queue.size
        for (i in 0 until queueSize) {
            val curr = queue.poll()
            //TODO target
            val index0 = curr.indexOf("0")
            // TODO 未完结的部分可见: https://labuladong.gitbook.io/algo/2020-nian-6-yue-zui-xin-wen-zhang/bfs-jie-jue-hua-dong-pin-tu
        }
    }

    return -1
}

fun main() {
    println("1. ${华容道("412503")}")
    println("2. ${华容道("342501")}")
}