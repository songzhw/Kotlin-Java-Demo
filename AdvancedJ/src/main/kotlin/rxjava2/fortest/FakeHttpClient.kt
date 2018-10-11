package rxjava2.fortest

class FakeHttpClient {

    fun fetchProfile(): Profile {
        Thread.sleep(4000)
        return Profile("szw")
    }

}