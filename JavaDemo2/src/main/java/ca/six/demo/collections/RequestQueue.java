package ca.six.demo.collections;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue {
    private PriorityBlockingQueue<Request> queue = new PriorityBlockingQueue<>();
    private AtomicInteger serialNumGenerator = new AtomicInteger(0);

    public void add(Request req) {
        // 不要无谓的重复请求， 有相同请求就只用新的
        if (queue.contains(req)) {
            queue.remove(req);
        }

        req.priority = generalSerialNumber();
        queue.add(req);
    }

    private int generalSerialNumber() {
        return serialNumGenerator.incrementAndGet();
    }
}
