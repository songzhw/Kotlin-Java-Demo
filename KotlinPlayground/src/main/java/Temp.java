import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;

public class Temp {
    public void foo(){
        Flowable flow;

        flow.subscribe(new Subscriber() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
