package kotlint.dalambda;

/**
 * Created by hzsongzhengwang on 2015/11/5.
 */
public class Button {

    public void setOnTouchListener(OnTouchListener alis){
        System.out.println("szw Button setOnTouchListener : "+alis.onTouch(23));
    }
}
