package ca.six.kjdemo;

class Temp {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 10; j > 7; j--) {
                System.out.println("i = " + i + "; j = " + j);
                if (j == 9) {
                    break;
                }
            }
        }
    }
}
// i, j 分别等于: 0, 10, 0,9;  1, 10, 1,9; 2,10, 2,9;  3,10, 3,9;
// 可见这个break是只有break一层的. 要想break双层, 在最外层的for循环里自己再加个break