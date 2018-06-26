package javaa.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class JavassistDemo {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        CtClass clazz = pool.get("javaa.javassist.Target");
        if (clazz.isFrozen()) {
            clazz.defrost();
        }

        CtMethod[] allMethods = clazz.getDeclaredMethods();

        for (CtMethod method : allMethods) {
            String name = method.getName();
            method.insertBefore("long start = System.nanoTime();");
            method.insertAfter("long end = System.nanoTime();");
            method.insertAfter("System.out.println(\"szw javassit exec "+name+"() : \" + (end - start));");
        }

        clazz.writeFile();
    }
}
