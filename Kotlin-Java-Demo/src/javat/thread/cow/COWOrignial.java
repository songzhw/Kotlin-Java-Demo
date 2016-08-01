package javat.thread.cow;

/**
 * Created by songzhw on 2016-08-01.
 */
public class COWOrignial {
    public static void main(String[] args) {
        RealJob1 a = new RealJob1("1","1");
        RealJob1 b = new RealJob1("1","2");
        RealJob1 c = new RealJob1("3","3");
        RealJob1 d = new RealJob1("4","4");
        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        a.start();
        b.start();
        c.start();
        d.start();
    }
}
