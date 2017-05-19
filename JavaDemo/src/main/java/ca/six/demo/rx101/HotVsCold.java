package ca.six.demo.rx101;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotVsCold {

    public static void main(String[] args) throws Exception {
        holdCafe();
    }

    public static void holdCafe() throws Exception {
        Observable<Long> hotMusicCoffeeCafe = Observable.interval(1000, TimeUnit.MILLISECONDS);
        ConnectableObservable<Long> connectableObservable = hotMusicCoffeeCafe.publish();
        connectableObservable.connect(); //  Cafe open on this line and cafe boy start the system

        Consumer client1 = poem -> System.out.println("Client 1 poem" + poem);
        Consumer client2 = poem -> System.out.println("Client 2 poem" + poem);
        Consumer client3 = poem -> System.out.println("Client 3 poem" + poem);
        Consumer client4 = poem -> System.out.println("Client 4 poem" + poem);

        Thread.sleep(2000); // After two poems already played client 1 enter. So he should listens from poem 2.
        connectableObservable.subscribe(client1);
        Thread.sleep(1000); // Client two should start listening poem 3
        connectableObservable.subscribe(client2);

        Thread.sleep(4000); // Client 3 and 4 enter will start from poem 9.
        connectableObservable.subscribe(client3);
        connectableObservable.subscribe(client4);

        while (true) ;
    }

    public static void coldCafe() throws Exception {
        List<String> poemsPlayList = Arrays.asList("Poem 1", "Poem 2", "Poem 3");
        Observable coldMusicCoffeCafe = Observable.fromArray(poemsPlayList);

        Consumer client1 = poem -> System.out.println(poem);
        Consumer client2 = poem -> System.out.println(poem);
        Consumer client3 = poem -> System.out.println(poem);
        Consumer client4 = poem -> System.out.println(poem);

        coldMusicCoffeCafe.subscribe(client1);
        coldMusicCoffeCafe.subscribe(client2);
        System.out.println("before time = " + System.currentTimeMillis());

        Thread.sleep(2000);
        System.out.println("now time = " + System.currentTimeMillis());

        coldMusicCoffeCafe.subscribe(client3);
        coldMusicCoffeCafe.subscribe(client4);
    }
}