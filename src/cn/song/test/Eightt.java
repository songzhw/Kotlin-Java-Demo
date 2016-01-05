package cn.song.test;

import java.util.Date;

/**
 * Created by hzsongzhengwang on 2016/1/5.
 */
public class Eightt {

    public static void main(String[] args) {
        System.out.println(Long.toString(new Date().getTime(), 36));        // ij15x8se

        System.out.println(Integer.toHexString((int) new Date().getTime())); // 110123be
    }
}
