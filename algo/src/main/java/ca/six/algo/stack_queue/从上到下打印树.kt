package ca.six.algo.stack_queue

import ca.six.algo.bisearch.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/*
以下面的树来说
      5
   6       8
 3   2        7

那打印出来的结果应该是: 5 6 8 3 2 7
 */


fun printFromTop(root: TreeNode) {
    val printList = ArrayList<Int>()
    val horizontalNodes: Queue<TreeNode> = LinkedList() //LinkedList其实就是Queue

    printList.add(root.data)
    horizontalNodes.offer(root)

    while (!horizontalNodes.isEmpty()) {
        val node = horizontalNodes.poll();

        if (node.left != null) {
            printList.add(node.left!!.data)
            horizontalNodes.offer(node.left);
        }
        if (node.right != null) {
            printList.add(node.right!!.data)
            horizontalNodes.offer(node.right)
        }
    }

    println(printList)
}

fun main() {
    val n7 = TreeNode(7, null, null)
    val n3 = TreeNode(3, null, null)
    val n2 = TreeNode(2, null, null)
    val n6 = TreeNode(6, n3, n2)
    val n8 = TreeNode(8, null, n7)
    val n5 = TreeNode(5, n6, n8)

    printFromTop(n5) //=> 5 6 8 3 2 7

}