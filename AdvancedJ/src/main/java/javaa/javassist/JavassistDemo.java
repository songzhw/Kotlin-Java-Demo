package javaa.javassist;

import javassist.util.proxy.ProxyFactory;

public class JavassistDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setSuperclass(Target.class);  //说是superClass, 其实就是被代理的类.

        proxyFactory.setFilter(method -> method.getName().startsWith("exe")); //只有前缀是exe的方法才能被代理

        proxyFactory.setHandler((self, thisMethod, proceedMethod, methodArgs) -> {
            long start = System.nanoTime();
            Object result = proceedMethod.invoke(self, methodArgs);
            long end = System.nanoTime();
            System.out.println("szw javaassit proxy " + proceedMethod.getName() + "() : " + (end - start) + "ns");
            return result;
        }); //真正做代理


        Class<?> clz = proxyFactory.createClass(); //生成代理类
        Target beProxied = (Target) clz.newInstance();

        beProxied.act();
        beProxied.exeStringBuilder();
        beProxied.exeStrings();


    }


}
