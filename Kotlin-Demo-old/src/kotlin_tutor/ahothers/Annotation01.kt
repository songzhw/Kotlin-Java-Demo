//package cn.song.ahothers
//
///**
// * Created by hzsongzhengwang on 2015/8/18.
// */
//
//annotation class fancy
//
//@fancy class Foo{
//    @fancy fun baz(@fancy foo : Int) : Int {
//        return (@fancy 1)
//    }
//}
//
//// In most cases, the @ sign is optional.
//// It is only required when annotating expressions or local declarations:
//
//
//// ======================================
//
//// 2. Annotations also may have constructor
//annotation class special(val why: String)
//
//@special("example") class Foo2 {}
//
//// ======================================
//
//// 3. Annotaitons can also be used on lambdas. For instance, a third library for concurrency control
//annotation class Suspendable
//
//val f = @Suspendable { /*Fiber.sleep(10)*/ }
//
//// ======================================
//
//// 4. Java annotaions are 100% compatible with Kotlin
//
//// ======================================
//
//// 5.