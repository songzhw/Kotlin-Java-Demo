package ca.six.algo.linkedlist

// 给定Header与toBeDeleted结点, 要求删除toBeDeleted结点
fun deleteNode(header: NodeC, toBeDeleted: NodeC) {

}

fun main() {
    val node5 = NodeC(5)
    val node4 = NodeC(4, node5)
    val node3 = NodeC(3, node4)
    val node2 = NodeC(3, node3)
    val node1 = NodeC(3, node2)
    val list = LinkedListC(node1);

    deleteNode(node1, node3)
}