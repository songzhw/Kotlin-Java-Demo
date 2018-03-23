package ca.six.demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public abstract class AsyncTask<Params, Progress, Result> {
    private static final int MESSAGE_POST_RESULT = 0x1;
    private static final int MESSAGE_POST_PROGRESS = 0x2;

    private final WorkerRunnable<Params, Result> worker;
    private final FutureTask<Result> future;

    private Handler handler;

    protected AsyncTask() {
        handler = new Handler(Looper.getMainLooper());

        worker = new WorkerRunnable<Params, Result>() {
            @Override
            public Result call() throws Exception {
                Result result = doInBackground(params);
                return result;
            }
        };



        future = new FutureTask<Result>(worker){
            @Override
            protected void done() {
                try {
                    Result result = get();
                    Message message = handler.obtainMessage(MESSAGE_POST_RESULT, result);
                    message.sendToTarget(); //target就是Handler. 这里其实就是handler.sendMessage(message)
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    protected abstract Result doInBackground(Params... params);

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] params;
    }
}

class Message {
    void sendToTarget() {};
}

class Handler {
    Handler(Looper loop){};
    Message obtainMessage(int what, Object obj) {return null;};
}

class Looper{
    static Looper getMainLooper(){return null;}
}

