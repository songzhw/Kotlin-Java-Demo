package ca.six.demo.collections;

public class Request {
    public int priority;

    public Request(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Request{" +
                "priority=" + priority +
                '}';
    }
}
