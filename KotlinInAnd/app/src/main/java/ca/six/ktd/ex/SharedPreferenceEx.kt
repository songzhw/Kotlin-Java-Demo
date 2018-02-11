package ca.six.ktd.ex

import android.content.SharedPreferences

inline fun SharedPreferences.does(act : SharedPreferences.Editor.()->Unit){
    val editor = edit()
    act(editor)
    editor.apply()
}

// https://github.com/android/android-ktx/blob/master/src/main/java/androidx/content/SharedPreferences.kt

// ?1: inline作用
// ?2: act是()->Unit类型. 但demo中putString函数是 (string, string) -> Editor. ?
// ?3: act是()->Unit类型. 但为何传入editor做参数
// ?4: act(editor)中传入了editor, 为何在demo中用不到.