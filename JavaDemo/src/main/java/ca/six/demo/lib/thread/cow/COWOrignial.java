package ca.six.demo.lib.thread.cow;

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

/*
begin:1470087307

[key = 1, value = 1] :1470087308
[key = 1, value = 2] :1470087308
[key = 3, value = 3] :1470087308
[key = 4, value = 4] :1470087308

 */