package test

import ExecutionTimeRunner
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith


@RunWith(ExecutionTimeRunner::class)
class UnknownSystemTest2 {

    lateinit var target: UnknownSystem

    @Before
    fun setup() {
        println("szw @Before")
        val worker = UnknownWorker()
        target = UnknownSystem(worker)
    }

    @After
    fun teardown() {
        println("szw @after")
    }

    @Test
    fun add() {
        val result = target.add(3, 2)
        assertEquals(5, result);
    }

    @Test
    fun command() {
    }
}