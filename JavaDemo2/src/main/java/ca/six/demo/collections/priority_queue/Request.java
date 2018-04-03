package ca.six.demo.collections.priority_queue;

import java.util.Objects;

public class Request {
    public int priority;
    public String url;
    public String headers;

    public Request(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Request{" +
                "priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return Objects.equals(url, request.url) &&
                Objects.equals(headers, request.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, headers);
    }
}
