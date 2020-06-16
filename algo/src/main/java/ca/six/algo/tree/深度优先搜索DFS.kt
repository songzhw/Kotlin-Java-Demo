package ca.six.algo.tree

import java.util.*
import kotlin.collections.ArrayList

/*
              9
     5                 20
  3     7         15        24
1   4 6   8    12    18  22     28
 */

fun DFS(root: TreeNode) {
    val result = ArrayList<Int>()
    val stack = Stack<TreeNode>()

    stack.push(root)

    while (!stack.isEmpty()) {
        val node = stack.pop()
        result.add(node.data)

        if (node.right != null) {
            stack.push(node.right) //先存右边. 栈是先进后出, 我们要先遍历左树, 所以要先存右树
        }
        if (node.left != null) {
            stack.push(node.left)
        }
    }

    println(result)
}

fun main() {
    DFS(n9)
}