package ca.six.ktd

import android.app.Activity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_anko_coroutine.*

class AnkoCoroutineActivity : Activity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anko_coroutine)

        btnCoroutineDemo.setOnClickListener(this)
        getData()
    }

    override fun onClick(p0: View?) {
        println("szw click")
    }

    fun getData() : Int{
        println("szw Thread : "+Thread.currentThread().name)
        Thread.sleep(5000)
        println("szw sleep over")
        return 23
    }
}
