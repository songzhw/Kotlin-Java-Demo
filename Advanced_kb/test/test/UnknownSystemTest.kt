package test

import ExecutionTimeRule
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class UnknownSystemTest {
    @Rule
    var rule = ExecutionTimeRule()

    lateinit var target: UnknownSystem

    @Before
    fun setup() {
        val worker = UnknownWorker()
        target = UnknownSystem(worker)
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