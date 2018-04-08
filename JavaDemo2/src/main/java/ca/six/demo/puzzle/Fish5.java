package ca.six.demo.puzzle;

public class Fish5 {

    public static void main(String[] args) {
        int[] ary = new int[5]; //初始值全为0
        int num = 1;

        // 试图找到num这个值. 若不符合其中的条件, 就num++, 再次找是否合适.
        for (num = 1; ; num++) {

            int sum = num;
            // 共5个人, 所以5个人都要保证这个条件
            for (int i = 0; i < 5; i++) {
                if (sum % 4 == 0) {
                    sum = sum / 4 * 5 + 1;
                    ary[i] = sum;
                } else {
                    i = 10; //跳出内层循环, 让num++继续尝试一个新数字
                }
            }

            // ary中5中数值都有值了, 说明已经到达了我们的条件了
            if (ary[4] > 0) {
                for (int j = 1; j < 6; j++) {
                    int myShare = (ary[j - 1] - 1) / 5;
                    System.out.println("第 " + j + " 个人 共看到 " + ary[j - 1] + " 条鱼" +
                            " ; 自己分得 " + myShare + " 条鱼");
                }
                break;
            }

        }

        System.out.println(" = = = = = = = = = = = = = = = = = = = = = = ");
    }

}
/*
有5个人大半夜地去捕鱼，到第二天响午才陆续醒来。
第一个醒来的人将鱼分为5份，然后把多余的一条丢了……拿走了自己的一份。
然后第二个人也将鱼分为5分，居然也把多余的一条给丢了……当然也不忘自己的一份。
同样的，后面三个人也采用了相同的操作。
那么他们至少捕了多少条鱼呢？
 */
