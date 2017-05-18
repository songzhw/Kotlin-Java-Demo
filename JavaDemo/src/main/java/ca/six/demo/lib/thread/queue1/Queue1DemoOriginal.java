package ca.six.demo.lib.thread.queue1;

import ca.six.demo.lib.thread.ThreadUtils;

/**
 * Created by songzhw on 2016-07-29.
 */
public class Queue1DemoOriginal {

    public static void main(String[] args) {
        System.out.println("begin = "+System.currentTimeMillis()/1000);
        for(int i = 1 ; i <= 16; i++){
            String log = ""+i;
            parseLog(log);
        }
    }

    public static void parseLog(String log){
        System.out.println("log["+log+"] = "+System.currentTimeMillis()/1000);
        ThreadUtils.sleep(1000);
    }
}

//=> 这代码的结果是需要16秒才打印完了。