package rxjava2.fortest

class FakeHttpClient {

    fun fetchProfile(): Profile {
        println("szw src FakeHttpClient.fetchProfile() : thread = ${Thread.currentThread().name}")
        Thread.sleep(4000)
        return Profile("szw")
    }

}