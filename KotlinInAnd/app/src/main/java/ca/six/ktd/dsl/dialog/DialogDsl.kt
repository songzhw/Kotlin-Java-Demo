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

    operator fun String.unaryMinus(): AlertDialog.Builder {
        builder.setTitle(this)
        return builder
    }

    operator fun String.unaryPlus(): AlertDialog.Builder {
        builder.setMessage(this)
        return builder
    }

    fun yes(stringResId : Int, listener : (DialogInterface, Int) -> Unit) : AlertDialog.Builder {
        builder.setPositiveButton(stringResId, listener)
        return builder
    }

    fun no(stringResId : Int, listener : (DialogInterface, Int) -> Unit) : AlertDialog.Builder {
        builder.setNegativeButton(stringResId, listener)
        return builder
    }

    fun icon(iconResId : Int): AlertDialog.Builder {
        builder.setIcon(iconResId)
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

