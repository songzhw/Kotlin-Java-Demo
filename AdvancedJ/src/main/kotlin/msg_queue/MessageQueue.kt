package msg_queue

import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock

class MessageQueue {
    val lock = ReentrantLock()
    val emptyMessage = EmptyMessage()
    var messages: Message = emptyMessage  //初始状态是empty状态
    var isQuitting = false

    val notEmpty = lock.newCondition()

    fun next(): Message {
        var waitTimeMillis = 0L; //需要的时间. 0是无限休眠, 正数表示实际的休眠时间, 负数表示不休眠

        while (true) {
            try { //kotlin中try-catch并非强制. 但这里为了finally中lock.unlock(), 只好加个try{}
                lock.lockInterruptibly()
                waitMessag(waitTimeMillis); //若没有马上就可以处理的消息, 那方法就要在这行被堵塞了
                if (isQuitting) return emptyMessage  // java中是return null; 这里就改了, 以适应kotlin

                val now = System.currentTimeMillis()
                val msg = messages
                if (msg is EmptyMessage) {
                    waitTimeMillis = -1 //缓冲区没有数据, 但线程被唤醒, 说明消息循环需要退出, 所以等待时间置为负数
                } else {
                    // 缓冲区内有数据, 要么取出msg并返回, 要么就计算下等待时间并重新休眠
                    if (now < msg._when) {
                        waitTimeMillis = msg._when - now  //后面waitMessage(long)时会休息的
                    } else {
                        messages = messages.next
                        msg.next = emptyMessage
                        return msg
                    }
                }
            } finally {
                lock.unlock()
            }
        }

    }

    fun waitMessag(waitTimeMillis: Long) {
        if(waitTimeMillis < 0) return

        if(waitTimeMillis == 0L){
            while(messages is EmptyMessage){
                notEmpty.await()
            }
        } else {
            notEmpty.await(waitTimeMillis, TimeUnit.MILLISECONDS)
        }
    }

    fun quit(){
        lock.lock()
        isQuitting = true
        notEmpty.signal()
        lock.unlock()
    }

    fun enqueue(msg : Message) : Boolean {
        try{
            lock.lockInterruptibly()
            if(isQuitting) return false
            insertMessage(msg)
            notEmpty.signal()  //唤醒消费者线程了
            return true
        } finally {
            lock.unlock()
        }
        return false
    }

    private fun insertMessage(msg : Message) {
        var currentInQueue = messages
        // 若队列为空, 或是队首的执行时间比我们msg还晚, 那就我们msg放队首
        if(messages is EmptyMessage || messages._when < currentInQueue._when){
            msg.next = messages
            messages = msg
            return
        }

        // 若msg执行时间比队首messages更晚, 那就先插入, 再遍历地来调整好顺序
        var pre = currentInQueue
        currentInQueue = currentInQueue.next
        while(currentInQueue !is EmptyMessage && currentInQueue._when < msg._when){
            pre = currentInQueue
            currentInQueue = currentInQueue.next
        }
        msg.next = currentInQueue
        pre.next = msg  // 插入到[pre, currentInQueue]之间
    }
}