package ca.six.demo.lib.mock.login3;

/**
 * Created by songzhw on 2016-09-19.
 */
public interface ILoginCallback {
    void onSucc(String resp);
    void onFail(Throwable throwable);
}
