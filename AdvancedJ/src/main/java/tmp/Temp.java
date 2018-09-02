package tmp;

import java.io.RandomAccessFile;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Temp {
    public static void main(String[] args) {
        Observable.just(23)
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
                    @Override
                    public ObservableSource<? extends Integer> apply(Throwable throwable) throws Exception {
                        return Observable.just(300);
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("onNext() : " + integer);
                    }
                });

    }

    public int minSwap(int[] ary){
        int swapTimes = 0;
        int size = ary.length;
        for(int i = 0; i < size; i++){
            if(ary[i] == i){
                continue;
            }

            swapTimes++;
            i--;
        }
        return swapTimes;
    }

}





