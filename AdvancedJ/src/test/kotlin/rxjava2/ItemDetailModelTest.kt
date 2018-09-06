package rxjava2

import org.junit.Assert.*
import org.junit.Test

class ItemDetailModelTest {
    @Test fun getItemDetail(){
        val model = ItemDetailModel()

        model.getItemDetail(object : HttpCallback<String>{
            override fun onSucc(ret: String) {
                assertEquals("xxxx server", ret)
            }
        })

    }
}