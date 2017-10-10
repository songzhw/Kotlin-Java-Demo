package ca.six.ktd

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_anko_coroutine.*
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class AnkoCoroutineActivity : Activity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anko_coroutine)

        btnCoroutineDemo.setOnClickListener(this)

        async(UI){
            val value : Deferred<Int> = bg {
                getData()
            }
            showData( value.await())
        }
    }

    override fun onClick(p0: View?) {
        println("szw click")
    }

    fun getData(): Int {
        println("szw Thread1 : " + Thread.currentThread().name)
        Thread.sleep(5000)
        println("szw sleep over")
        return 23
    }

    fun showData(value: Int) {
        println("szw Thread2 : " + Thread.currentThread().name)
        btnCoroutineDemo.setText("new " + value)
    }
}