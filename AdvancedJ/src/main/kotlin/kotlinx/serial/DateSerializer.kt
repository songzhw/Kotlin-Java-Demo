package kotlinx.serial

import kotlinx.serialization.KInput
import kotlinx.serialization.KOutput
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import java.text.SimpleDateFormat
import java.util.*

@Serializer(forClass = Date::class)
class DateSerializer : KSerializer<Date>{
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    override fun load(input: KInput): Date  =
            dateFormat.parse((input.readStringValue()))

    override fun save(output: KOutput, obj: Date) {
        output.writeStringValue(dateFormat.format(obj))
    }
}