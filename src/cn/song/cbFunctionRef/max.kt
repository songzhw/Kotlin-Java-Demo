package cn.song.cbFunctionRef

/**
 * Created by hzsongzhengwang on 2015/9/11.
 */


// "less : (T, T) -> Boolean" , means a function takes two parameters of type T,
// and return a Boolean
fun max<T>(collection : Collection<out T>, less: (T,T)-> Boolean) : T? {
    var maxNum : T? = null
    collection.forEach {
        // if this is "less(maxNum, it)", it is wrong. because maxNum may be null
        // and our definition :"less(T,T) -> Boolean" requires a not-null T
        if(maxNum == null || less(maxNum!!, it)){
            maxNum = it
        }
    }
    return maxNum
}

// note : “!!” operation
// : b!! will return a non-null value of b, or throw an NPE if b is null

// note: " ?. " opetion
// : b?.length returns b.length() if b is not null, and return null otherwise.
// and note that, the type of this expression is "Int?"