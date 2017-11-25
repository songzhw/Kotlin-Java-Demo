package ca.six.klplay.dsl

class Html {
    val children = arrayListOf<Tag>()

    fun head(work: Head.()->Unit) : Head {
        val head = Head()
        head.work()
        children.add(head)
        return head
    }

    fun body(work: Body.()->Unit) : Body {
        val body = Body()
        body.work()
        children.add(body)
        return body
    }

}
