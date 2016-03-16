package javat.hongbao;

import java.util.Random;

/**
 * Created by songzhw on 2016/2/18.
 *
 * 如何在一堆人中生成随机红包
 */
public class HongBao {

    public static double getRandomMoney(HongBaoLeft left) {
        if (left.peoples == 1) {
            left.peoples--;
            return (double) Math.round(left.money * 100) / 100; // 来获得只有两位小数. 因为Math.round()返回提long型，所以会自动转为2位小数的
        }
        Random r = new Random();

        double min = 0.01;
        double max = left.money / left.peoples * 2; //最大值是： 剩余人数平均值 的2倍。 保证不会有人拿走巨大的一份

        double money = r.nextDouble() * max;
        money = money < min ? min : money;
        money = (double) Math.floor(money * 100) / 100;

        left.peoples--;
        left.money -= money;

        return money;
    }

    public static void main(String[] args) {

        HongBaoLeft left = new HongBaoLeft();
        left.peoples = 10;
        left.money = 300;

        for(int i = 0 ; i < 10; i++){
            double money = getRandomMoney(left);
            System.out.println("["+i+"] = "+money);
        }
    }

}
