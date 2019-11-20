package threads

import java.util.*

class Chopstick(val id: Int)

class Philosopher(val name: String, val left: Chopstick, val right: Chopstick) {
    val big: Chopstick = if (left.id > right.id) left else right
    val small: Chopstick = if (left.id > right.id) right else left
    val random: Random = Random()

    fun eat() {
        while (true) {
            Thread.sleep(random.nextInt(1000).toLong())
            synchronized(big) {
                System.out.println("szw p[" + name + "] got left");
                Thread.sleep(1000);
                synchronized(small) {
                    System.out.println("szw p[" + name + "] got right");
                    Thread.sleep(random.nextInt(1000).toLong());
                }
            }
        }
    }
}

