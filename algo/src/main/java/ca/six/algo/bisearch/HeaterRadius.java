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
        int[] heaters = new int[]{2, 4};
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
        } else {
            int max = 0;
            for (int i = 0; i < (heatersLength - 1); i++) {
                int heater = heaters[i];
                int index = getIndex(houses, heater);
                int prevIndex, nextIndex;
                if (i == 0) {
                    prevIndex = 0;
                    nextIndex = getIndex(houses, heaters[i+1]);
                } else if (i == houses.length - 1) {
                    prevIndex = getIndex(houses, heaters[i-1]);
                    nextIndex = houses.length - 1;
                } else {
                    prevIndex = getIndex(houses, heaters[i-1]);
                    nextIndex = getIndex(houses, heaters[i+1]);
                }
                max = Math.max(index - prevIndex, nextIndex - index);
            }
            return max;
        }
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
