package ca.six.jold;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class C5 {
    OnChange listener;

    public void setOnChangeListener(OnChange listener) {
        this.listener = listener;
    }

    public void change() {
        listener.change(23, 100, "bing");
    }

    public void temp(){
        Observable<Long> one = Observable.interval(3, TimeUnit.SECONDS);
        Observable<Long> two = Observable.interval(2, TimeUnit.SECONDS);
        two.withLatestFrom(one, new BiFunction<Long, Long, String>() {
            @Override
            public String apply(Long num1, Long num2) throws Exception {
                return "";
            }
        })
        .subscribe();
    }
}
