package lambda;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by songzhw on 2016/3/14.
 */
public class TryMixin {
    interface FakeBrokenMixin {
        Map<FakeBrokenMixin, String> backingMap
                = Collections.synchronizedMap(new WeakHashMap<FakeBrokenMixin, String>());

        default String getName() {
            return backingMap.get(this);
        }

        default void setName(String name) {
            backingMap.put(this, name);
        }
    }

    interface X extends Runnable, FakeBrokenMixin { }

    X makeX() {
        return () -> {
            System.out.println("X");
        };
    }

    void test() {
        X x1 = makeX();
        X x2 = makeX();
        x1.setName("x1");
        x2.setName("x2");
        System.out.println(x1.getName());
        System.out.println(x2.getName());

        System.out.println(x1);   // lambda.TryMixin$$Lambda$1/990368553@6d311334
        System.out.println(x2);   // lambda.TryMixin$$Lambda$1/990368553@6d311334

        System.out.println(x1.getClass());   // class lambda.TryMixin$$Lambda$1/990368553
        System.out.println(x2.getClass());   // class lambda.TryMixin$$Lambda$1/990368553
    }


    public static void main(String[] args) {
        TryMixin obj = new TryMixin();
        obj.test();
    }


}
