package ca.six.ktd.dsl.dialog


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.test.mock.MockContext

/*
-       title
+       message
yesBtn  click listener
noBtn   click listener
*/
class DialogDsl(val context: Context) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)

    operator fun String.unaryMinus(): AlertDialog.Builder {
        builder.setTitle(this)
        return builder
    }

    operator fun String.unaryPlus(): AlertDialog.Builder {
        builder.setMessage(this)
        return builder
    }

}

fun Activity.dialog(block: DialogDsl.() -> AlertDialog.Builder): AlertDialog {
    val dsl = DialogDsl(this)
    return dsl.block().create();

}

class DislogDstDemo : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dialog {
            -"Title"
            +"Message, Content, Others"
        }.show()
    }
}
