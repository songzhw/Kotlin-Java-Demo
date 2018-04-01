package ca.six.demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public abstract class AsyncTask<Params, Progress, Result> {
    private static final int MESSAGE_POST_RESULT = 0x1;
    private static final int MESSAGE_POST_PROGRESS = 0x2;

    private final WorkerRunnable<Params, Result> worker;
    private final FutureTask<Result> future;

    private Handler handler;

    protected AsyncTask() {
        worker = new WorkerRunnable<Params, Result>() {
            @Override
            public Result call() {
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

        handler = new Handler(Looper.getMainLooper()) {
            @Override
            void handleMessage(Message msg) {
                Result result = (Result) msg.obj;
                onPostExecute(result);
            }
        };
    }

    protected abstract Result doInBackground(Params... params);

    protected void onPostExecute(Result result) {}

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] params;
    }
}

class Message {
    Object obj;
    void sendToTarget() {}
}

class Handler {
    Handler(Looper loop){}
    Message obtainMessage(int what, Object obj) {return null;}
    void handleMessage(Message msg){}
}

class Looper{
    static Looper getMainLooper(){return null;}
}

