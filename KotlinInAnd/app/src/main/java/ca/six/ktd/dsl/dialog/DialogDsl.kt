package ca.six.ktd.dsl.dialog

import android.app.AlertDialog
import android.content.Context
import android.test.mock.MockContext

/*
-       title
+       message
yesBtn  click listener
noBtn   click listener
 */
fun dialog(context: Context, block: () -> Unit): AlertDialog {
    val dsl = DialogDsl(context)


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

}


fun main(args: Array<String>) {
    val context = MockContext()  // TODO change it later
    val dialog = dialog(context) {
        +"This is title"
        -"Meesage 001, content 002, and others 003"
    }
    dialog.show()
}