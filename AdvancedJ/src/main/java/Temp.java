import aop.proxy.retrofit.Call;
import aop.proxy.retrofit.Demo.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IClickListener {
    void click(String view);

}

class ButtonClickListener implements IClickListener {
    @Override
    public void click(String view) {
        System.out.println("click " + view);
    }

}

class TraceHelper implements InvocationHandler {
    private IClickListener target;

    public TraceHelper(IClickListener target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before tracking");
        method.invoke(target, args);
        System.out.println("done with tracking");
        return null;
    }

}

public class Temp {
    public static void main(String[] args) {
        IClickListener hello = enhanceHello(new ButtonClickListener());
        hello.click("ImageView");
    }

    public static IClickListener enhanceHello(IClickListener target) {
        return (IClickListener) Proxy.newProxyInstance(
                Temp.class.getClassLoader(),
                new Class<?>[]{IClickListener.class},
                new TraceHelper(target)
        );
    }

    public void a(){
        Call<User> c = new Call<User>() {
            @Override
            public void call(User user) {

            }
        };
    }
}





