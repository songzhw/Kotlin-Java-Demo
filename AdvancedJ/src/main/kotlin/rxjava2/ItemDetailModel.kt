package rxjava2

class ItemDetailModel {
    fun getItemDetail(callback: HttpCallback<String>) {
        HttpEngine.getItemDetail(callback)
    }
}