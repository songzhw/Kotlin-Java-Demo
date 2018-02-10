package ca.six.ktd.and

import android.graphics.Outline
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ViewOutlineDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val roundImage = ImageView(this)
            roundImage.clipToOutline = true
            roundImage.outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, 30f)
                }
            }

        }
    }
}
