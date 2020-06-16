package ca.six.algo.tree

import java.util.*


/*

  3
2   5
  4   7
那这个树的最小高度就是2 (即3->2这一分支. 3->5这一分支的高度为3)
现在给定一个二叉树, 要求其的最小高度
 */

fun minHeight(root: TreeNode?): Int {
    if (root == null) return 0

    val queue = LinkedList<TreeNode>()
    queue.offer(root) //offer()就是添加元素
    var depth = 1

    while (!queue.isEmpty()) {
        for (i in 0 until queue.size) {
            val node = queue.poll() //poll()就是取元素
            if(node.left == null && node.right == null){
                return depth;
            }

            if(node.left != null) queue.offer(node.left)
            if(node.right != null) queue.offer(node.right)
        }
        depth++
    }
    return depth;
}

fun main() {
    val n7 = TreeNode(7, null, null)
    val n4 = TreeNode(4, null, null)
    val n5 = TreeNode(5, n4, n7)
    val n2 = TreeNode(2, null, null)
    val n3 = TreeNode(3, n2, n5)

    val minHeight = minHeight(n3)
    println("minHeight = $minHeight")
}