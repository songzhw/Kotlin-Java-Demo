package ca.six.ktd.dsl.dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

/*
-       title
+       message
yesBtn  click listener
noBtn   click listener
 */
fun Activity.dialog(block: () -> Unit): Unit {
    val dsl = DialogDsl(this)

    // TODO dialog.show()
}

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

    fun yesButton(text: String, listener: DialogInterface.OnClickListener): AlertDialog.Builder {
        builder.setPositiveButton(text, listener)
        return builder
    }

    fun noButton(text: String, listener: DialogInterface.OnClickListener): AlertDialog.Builder {
        builder.setNegativeButton(text, listener)
        return builder
    }
}


class DialogDslDemo : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/*        dialog {
            +"title"
            -"message and content"
            yesButton("ok") {

            }
            noButton("cancel") {

            }
        }*/

        alert("title", "message") {
            yesButton { toast("oh...") }
            noButton {  }
        }.show()
    }
}