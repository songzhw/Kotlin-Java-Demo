import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.model.FrameworkMethod
import org.junit.runners.model.Statement

class ExecutionTimeRunner(clazz: Class<*>) : BlockJUnit4ClassRunner(clazz) {

    override fun withBefores(method: FrameworkMethod, target: Any, base: Statement): Statement {
        val junitStatement = super.withBefores(method, target, base)
        return object : Statement() {
            override fun evaluate() {
                println("szw 自定义Runner.Before")
                junitStatement.evaluate()
            }
        }
    }

}