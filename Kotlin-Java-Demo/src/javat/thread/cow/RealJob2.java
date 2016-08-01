package javat.thread.cow;

import javat.thread.ThreadUtils;

/**
 * Created by songzhw on 2016-08-01.
 */
public class RealJob2 extends Thread{
    private String key, value;

    public RealJob2(String k, String v){
        key = k + ""; //保证两个对象初始化时， k都是"1"， 但得到的this.key是不同的对象。 毕竟常量"1"和"1"是同一个对象
        value = v;
    }

    @Override
    public void run() {
        ThreadUtils.sleep(1000);
        System.out.println("[key = " + key + ", value = "+ value + "] :" + (System.currentTimeMillis() / 1000));
    }
}
