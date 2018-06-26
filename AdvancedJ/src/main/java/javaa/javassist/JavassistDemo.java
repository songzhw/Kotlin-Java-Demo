package javaa.javassist;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
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


    /*
    // 出错: no such field: start -- javaassit找不到局部变量
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        CtClass clazz = pool.get("javaa.javassist.Target");
        if (clazz.isFrozen()) {
            clazz.defrost();
        }

        CtMethod[] allMethods = clazz.getDeclaredMethods();

        for (CtMethod method : allMethods) {
            String name = method.getName();
            method.insertBefore("long start = System.nanoTime();\n");
            method.insertAfter("long end = System.nanoTime();\nSystem.out.println(\"szw javassit exec "+name+"() : \" + (end - start));\n");
        }

        clazz.writeFile();
        clazz.detach();
    }*/
}
