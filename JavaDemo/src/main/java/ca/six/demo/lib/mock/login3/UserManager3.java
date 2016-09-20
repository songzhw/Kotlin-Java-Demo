package ca.six.demo.lib.mock.login3;

import java.nio.file.AccessDeniedException;
import java.util.Random;

/**
 * Created by songzhw on 2016-09-19.
 *
 */
public class UserManager3 {
    public void doLogin(String name, String pwd, ILoginCallback callback){
        System.out.println("doLogin() : name = "+name+" ; pwd = "+pwd);
        int randomInt = new Random().nextInt();
        if(randomInt % 2 == 0 ) {
            callback.onSucc("succ");
        } else {
            callback.onFail(new AccessDeniedException("failed!"));
        }
    }
}
