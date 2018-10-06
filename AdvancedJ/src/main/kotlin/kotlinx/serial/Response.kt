//package kotlinx.serial
//
//import kotlinx.serialization.Serializable
//import java.util.*
//
//// 不加@Serializable, 就会运行时报错: " Can't locate default serializer for class kotlinx.serial.Response (Kotlin reflection is not available)"
//@Serializable
//data class Response(val code : Int,
//                    val msg: String,
//                    @Serializable(with = DateSerializer::class) val timestamp: Date){
//
//}