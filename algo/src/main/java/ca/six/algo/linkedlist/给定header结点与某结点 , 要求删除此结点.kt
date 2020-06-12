package ca.six.algo.linkedlist

// 给定Header与toBeDeleted结点, 要求删除toBeDeleted结点
fun deleteNode(header: NodeC, toBeDeleted: NodeC) {
    val next1 = toBeDeleted.next
    val next2 = next1!!.next

    toBeDeleted.data = next1.data
    toBeDeleted.next = next2

    var temp: NodeC? = header
    while (temp != null) {
        print("${temp.data}, ")
        temp = temp.next
    }
}

fun main() {
    val node5 = NodeC(5)
    val node4 = NodeC(4, node5)
    val node3 = NodeC(3, node4)
    val node2 = NodeC(2, node3)
    val node1 = NodeC(1, node2)

    deleteNode(node1, node3) //=> 1,2,4,5
}