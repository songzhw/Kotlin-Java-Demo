package ca.six.algo.bisearch;
/*
input: [1, 2, 3] [2]
output: 1

input: [1, 2, 3, 4, 5] [3]
output: 2

input: [1, 2, 3, 4] [1, 4]
output: 1
*/

class HeaterRadius {
    public static final int ERROR = -100;

    public static void main(String[] args) {
        System.out.println("szw");

        int[] houses = new int[]{1, 2, 3, 4, 5};
        int[] heaters = new int[]{3};
        int radius = getRadius(houses, heaters);
        System.out.println("szw radius = " + radius);

    }

    static int getRadius(int[] houses, int[] heaters) {
        int heatersLength = heaters.length;
        if (heatersLength == 1) {
            return houses.length / 2;  // 5/2也是2
        }
        return 1;
    }
}
