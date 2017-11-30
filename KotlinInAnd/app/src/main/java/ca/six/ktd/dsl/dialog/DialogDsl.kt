package ca.six.ktd.dsl.dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import ca.six.ktd.R

/*
-       title
+       message
yesBtn  click listener
noBtn   click listener
*/
class DialogDsl(val context: Context) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)

    operator fun String.unaryMinus() {
        builder.setTitle(this)
    }

    operator fun String.unaryPlus() {
        builder.setMessage(this)
    }

    fun yes(stringResId: Int, listener: (DialogInterface, Int) -> Unit) {
        builder.setPositiveButton(stringResId, listener)
    }

    fun no(stringResId: Int, listener: (DialogInterface, Int) -> Unit) {
        builder.setNegativeButton(stringResId, listener)
    }

    fun icon(iconResId: Int) {
        builder.setIcon(iconResId)
    }

}

fun Activity.dialog(block: DialogDsl.() -> Unit): AlertDialog {
    val dsl = DialogDsl(this)
    dsl.block()
    return dsl.builder.create()

}

class DislogDstDemo : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dialog {
            -"Title"
            +"Message, Content, Others"
            icon(R.drawable.ic_launcher)
            yes(R.string.app_name) { dialog, which ->
                println("press ok : ${dialog} at $which")
            }
            no(R.string.app_name) { dialog, which ->
                println("press no : ${dialog} at $which")
            }
        }.show()
    }
}
