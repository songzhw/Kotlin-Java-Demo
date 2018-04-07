package ca.six.demo.puzzle;

public class Fish5 {

    public static void main(String[] args) {
        int[] ary = new int[5]; //初始值全为0
        int num = 1;

        // 试图找到num这个值. 若不符合其中的条件, 就num++, 再次找是否合适.
        for (num = 1; ; num++) {

            // 共5个人, 所以5个人都要保证这个条件
            for (int i = 0; i < 5; i++) {
                int tmp = 5 * num + 1;
                if (tmp % 4 == 0) {
                    num = num / 4 * 5 + 1;
                    ary[i] = num;
                } else {
                    i = 10; //跳出内层循环, 让num++继续尝试一个新数字
                }
            }

            // ary中5中数值都有值了, 说明已经到达了我们的条件了
            if (ary[4] > 0) {
                for (int j = 1; j < 6; j++) {
                    System.out.println("第 " + j + " 个人 共看到 " + ary[j] + " 条鱼");
                }
                break;
            }

        }

        System.out.println(" = = = = = = = = = = = = = = = = = = = = = = ");
    }

}
