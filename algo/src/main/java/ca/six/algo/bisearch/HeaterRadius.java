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
        HeaterRadius obj = new HeaterRadius();

        int[] houses = new int[]{1, 2, 3, 4, 5};
        int[] heaters = new int[]{4};
        int radius = obj.getRadius(houses, heaters);
        System.out.println("szw radius = " + radius);

    }

    int getRadius(int[] houses, int[] heaters) {
        int heatersLength = heaters.length;
        if (heatersLength == 1) {
            int index = getIndex(houses, heaters[0]);
            int left = index;
            int right = houses.length - 1 - index;
            return Math.max(left, right);
        }
        return 1;
    }

    int getIndex(int[] houses, int heater) {
        for (int i = 0; i < houses.length; i++) {
            if (heater == houses[i]) {
                return i;
            }
        }
        return ERROR;
    }
}
