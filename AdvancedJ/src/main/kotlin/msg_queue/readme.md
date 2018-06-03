一个跨平台的消息循环机制，可以做到线程间通讯并支持发送延时消息。

与AndroidSDK类似，通过MessageQueue对象实现消息队列，通过Handler对象实现消息的发送与处理。
但Message与Looper都相应做了简化，只实现核心部分。

线程同步方面选用jdk提供的重入锁（非必须，可选其他）配合Condition完成线程的休眠与唤醒。

类图: https://user-gold-cdn.xitu.io/2017/11/27/15ffe11c18965da1?imageView2/0/w/1280/h/960/format/webp/ignore-error/1

