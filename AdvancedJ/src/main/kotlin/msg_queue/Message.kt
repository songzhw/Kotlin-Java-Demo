package msg_queue

open class Message {
    var what: Int = -1
    lateinit var obj: Object
    lateinit var target: Handler
    lateinit var callback: Runnable

    var _when: Long = -1  //kotlin中when是关键字,所以这里改名为"_when"
    lateinit var next: Message
}

class EmptyMessage : Message(){
}