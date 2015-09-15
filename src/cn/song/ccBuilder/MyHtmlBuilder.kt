package cn.song.ccBuilder

/**
 * Created by hzsongzhengwang on 2015/9/11.
 */
fun html(init: Html.()-> Unit) : Html {
    var html = Html()
    html.init()
    return html
}


class Html(){

}