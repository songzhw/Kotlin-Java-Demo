package msg_queue

open class Message {
    var what: Int = -1
    lateinit var obj: Any
    lateinit var target: Handler
    var runnableCallback: Runnable? = null

    var _when: Long = -1  //kotlin中when是关键字,所以这里改名为"_when"
    lateinit var next: Message
}

class EmptyMessage : Message(){
}