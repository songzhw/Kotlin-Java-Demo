package ca.six.demo.lib.thread.wait_notify;

public class SomeClass {
    private static String lock = "SomeClass_Lock";
    private static boolean hasFinishedStep01 = false;
    private static SomeClass instance = new SomeClass();
    private SomeClass(){}
    public static SomeClass getInstance(){
        return instance;
    }

    public void step01(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                _notify();
                hasFinishedStep01 = true;
            }
        }).start();
    }

    public void step02(/*final Handler handler*/){
        new Thread(new Runnable() {
            @Override
            public void run() {

                // 也不能每次都是在等，所以要有一个flag
                if(!hasFinishedStep01) {
                    _wait();
                }

//                Message msg = handler.obtainMessage();
//                msg.obj = "step02";
//                handler.sendMessage(msg);

            }
        }).start();
    }

    private void _wait(){
        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e){}
    }

    private void _notify(){
        synchronized (lock) {
            lock.notify();
        }
    }
}