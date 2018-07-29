package pojo

import org.json.JSONObject

/*
{
      "code": 100,
      "desp": "server connected",
      "data": {
            "id": 123,
            "content": "long long time ago"
      }
}
 */

data class StoryResponse(val json : String) {
    var code: Int = 0
    var desp: String = ""
    var id : Int = 0
    var story: String = ""

    init {
        val jsonObject = JSONObject(json)
        code = jsonObject.getInt("code")
        desp = jsonObject.getString("desp")

        val tmpData : JSONObject? = jsonObject.get("data") as JSONObject?
        id = tmpData?.getInt("id") ?: 0
        story = tmpData?.getString("content") ?: ""
    }
}