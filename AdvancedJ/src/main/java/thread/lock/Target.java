package thread.lock;

public class Target {
    synchronized public void outer() {
        inner();
    }

    synchronized public void inner() {
    }
}
