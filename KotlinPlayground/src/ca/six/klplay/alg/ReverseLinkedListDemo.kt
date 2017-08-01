package ca.six.klplay.alg

import kotlin.properties.Delegates

// http://blog.csdn.net/xiaozhuaixifu/article/details/9366733

class Node {
    var num: Int  by Delegates.notNull<Int>()
    var next: Node by Delegates.notNull<Node>()
}

class ReverseLinkedListDemo {
    val end = Node()

    fun reverse(head : Node) {
        var first = head.next
        var second = first.next
        if (second == end) {
            return
        }
        first.next = end // 前面second已经存了next.next

        while(second.next != end){
            var third = second.next

            second.next = first
            third.next = second
            first = second
            second = third

        }
        second.next = first
        head.next = second
    }

}

fun main(args: Array<String>) {
    
}
