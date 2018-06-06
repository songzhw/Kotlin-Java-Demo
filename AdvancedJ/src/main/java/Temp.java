import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IClickListener {
    void say(String s);

}

class ButtonClickListener implements IClickListener {
    @Override
    public void say(String s) {
        System.out.println("hello " + s);
    }

}

class TraceHelper implements InvocationHandler {
    private IClickListener target;  // 原始对象

    public TraceHelper(IClickListener target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before print");
        method.invoke(target, args);  // 调用原始对象的方法
        System.out.println("after print");
        return null;
    }

}

public class Temp {
    public static void main(String[] args) {
        IClickListener hello = enhanceHello(new ButtonClickListener());
        hello.say("world");
    }

    public static IClickListener enhanceHello(IClickListener target) {
        return (IClickListener) Proxy.newProxyInstance(
                Temp.class.getClassLoader(),
                new Class<?>[]{IClickListener.class},
                new TraceHelper(target)
        );
    }
}




