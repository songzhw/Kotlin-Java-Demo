package ca.six.algo.linkedlist

// 给定Header与toBeDeleted结点, 要求删除toBeDeleted结点
fun deleteNode(header: NodeC, toBeDeleted: NodeC) {
    val next1 = toBeDeleted.next
    val next2 = next1!!.next

    toBeDeleted.data = next1.data
    toBeDeleted.next = next2

    var temp = header
    while(temp.next != null){
        print("${temp.data}, ")
    }
}

fun main() {
    val node5 = NodeC(5)
    val node4 = NodeC(4, node5)
    val node3 = NodeC(3, node4)
    val node2 = NodeC(3, node3)
    val node1 = NodeC(3, node2)

    deleteNode(node1, node3)
}