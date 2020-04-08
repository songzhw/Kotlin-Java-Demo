package ca.six.kjdemo.proxy.kt

class Apple {
    val id: Int by lazy { 1 }
}

inline fun Apple.work(): Lazy<String> {
    return object : Lazy<String> {
        override val value: String = "hello"

        override fun isInitialized(): Boolean {
            return true;
        }
    }
}

//import androidx.lifecycle.ViewModelLazy
//@MainThread
//inline fun <reified VM : ViewModel> ComponentActivity.viewModels(
//    noinline factoryProducer: (() -> Factory)? = null
//): Lazy<VM> {
//    val factoryPromise = factoryProducer ?: {
//        defaultViewModelProviderFactory
//    }
//
//    return ViewModelLazy(VM::class, { viewModelStore }, factoryPromise)
//}
