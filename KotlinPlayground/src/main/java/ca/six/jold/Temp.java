package ca.six.jold;

import org.reactivestreams.Subscriber;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

class Temp {
    public void be() {
        BehaviorSubject<Integer> s = BehaviorSubject.create();
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.subscribe(v -> System.out.println("Late: " + v));
        s.onNext(3);
    }//=> Late 2, Late 3

    public void pu() {
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.onNext(1);
        subject.subscribe(System.out::println);
        subject.onNext(2);
        subject.onNext(3);
        subject.onNext(4);
    } //=> 2, 3, 4

    public void re(){
        ReplaySubject<Integer> s = ReplaySubject.create();
        s.subscribe(v -> System.out.println("Early:" + v));
        s.onNext(0);
        s.onNext(1);
        s.subscribe(v -> System.out.println("Late: " + v));
        s.onNext(2);
    }
    /*
    Early:0
    Early:1
    Late: 0
    Late: 1
    Early:2
    Late: 2
     */

    public static void main(String[] args) {
        Temp obj = new Temp();
        obj.pu();
        System.out.println("= = = = = = = ");
        obj.be();
        System.out.println("= = = = = = = ");
        obj.re();
    }
}
