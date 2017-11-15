package ca.six.demo.lib.thread.others;

public class FizzBuzzDemo {
    public void singleThread(int n){
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        int n = 20;
        Thread[] threads = {
                new FiBuzzThread(i -> i%3 == 0 && i % 5 == 0, i -> "FizzBuzz", n),
                new FiBuzzThread(i -> i%3 == 0 && i % 5 != 0, i -> "Fizz", n),
                new FiBuzzThread(i -> i%3 != 0 && i % 5 == 0, i -> "Buzz", n),
                new FiBuzzThread(i -> i%3 != 0 && i % 5 != 0, i -> ""+i, n),
        };

        for (Thread t : threads){
            t.start();
        }
    }

}
