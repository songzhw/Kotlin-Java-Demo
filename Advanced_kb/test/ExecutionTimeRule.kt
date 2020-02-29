import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class ExecutionTimeRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                //想要在测试方法运行之前做一些事情，就在base.evaluate()之前做
                //想要在测试方法运行之前做一些事情，就在base.evaluate()之前做
                val className = description.className
                val methodName = description.methodName
                println("szw before: class Name = $className")

                base.evaluate() //这其实就是运行测试方法

                //想要在测试方法运行之后做一些事情，就在base.evaluate()之后做
                //想要在测试方法运行之后做一些事情，就在base.evaluate()之后做
                println("szw after : method name: $methodName")
                println(" = = = = = = = = = = = = = = = = = = = = ")
            }
        }
    }
}