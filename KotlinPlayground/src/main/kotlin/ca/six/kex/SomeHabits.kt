package ca.six.kex

private fun getInfo(jsonObject: JSONObject?): Info? {
    return jsonObject?.let {
        val uri = it.optString("uri")
        val length = it.optString("length")
        Info(uri, length)
    }
}


class JSONObject{
    fun optString(str : String) : String {return ""}
}

class Info(val uri : String, var length: String){
}

// =========================================================



