package cn.six.rxtest.observ

import rx.Observable
import java.io.File

/**
 * Created by hzsongzhengwang on 2015/12/16.
 */

public class RxFileSimplizer{
    fun createFileFromUri(filePath : String ) : Observable<File>{
        var ret = Observable.defer{
            try{
                Observable.just(fileFromPath(filePath))
            } catch(e : Exception){
                Observable.error<File>(e)
            }
        }
        return ret
    }

    fun fileFromPath(filePath : String) : File {
        return File(filePath)
    }
}
