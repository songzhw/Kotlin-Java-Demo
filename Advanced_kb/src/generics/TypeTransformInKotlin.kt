package generics

import java.util.ArrayList

open class Universe
open class Sun : Universe()
open class Earth : Sun()

fun testSun1(ball: Sun) {}
fun testSun2(ball: List<out Sun>) {}
fun testSun3(ball: List<in Sun>) {}

fun main() {
    val universe = Universe()
    val sun = Sun()
    val earth = Earth()

    testSun1(universe)
    testSun1(sun)
    testSun1(earth)

    testSun2(universe)
    testSun2(sun)
    testSun2(earth)

    testSun3(universe)
    testSun3(sun)
    testSun3(earth)
}