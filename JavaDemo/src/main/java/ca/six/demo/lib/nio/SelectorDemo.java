package ca.six.demo.lib.nio;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by songzhw on 2017-03-01.
 */

// 与Selector一起使用时，Channel必须处于非阻塞模式下。这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。
public class SelectorDemo {
    public static void main(String[] args) {
//        Selector selector = Selector.open();
//        channel.configureBlocking(false);
//        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
//        while(true) {
//            int readyChannels = selector.select();
//            if(readyChannels == 0) {
//                continue;
//            }
//            Set selectedKeys = selector.selectedKeys();
//            Iterator keyIterator = selectedKeys.iterator();
//            while(keyIterator.hasNext()) {
//                key = keyIterator.next();
//                if(key.isAcceptable()) {
//                    // a connection was accepted by a ServerSocketChannel.
//                } else if (key.isConnectable()) {
//                    // a connection was established with a remote server.
//                } else if (key.isReadable()) {
//                    // a channel is ready for reading
//                } else if (key.isWritable()) {
//                    // a channel is ready for writing
//                }
//                keyIterator.remove();
//            }
//        }
    }
}
