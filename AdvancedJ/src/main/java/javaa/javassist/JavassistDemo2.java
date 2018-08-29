package javaa.javassist;

import java.io.File;
import java.lang.reflect.Modifier;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;

// TODO FAILED in JVM. However, running this code on Android Gradle Transformk will succeed!
public class JavassistDemo2 {

    // 出错: no such field: start -- javaassit找不到局部变量
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        CtClass clazz = pool.get("javaa.javassist.Target2");
        if (clazz.isFrozen()) {
            clazz.defrost();
        }


        CtMethod[] allMethods = clazz.getDeclaredMethods();

        for (CtMethod method : allMethods) {
            String name = method.getName();
            method.addLocalVariable("start", CtClass.longType);
            method.insertBefore("start = System.nanoTime();\n");
            method.insertAfter("long end = System.nanoTime();\nSystem.out.println(\"szw javassit exec "+name+"() : \" + (end - start));\n");
        }

        File thisFile = new File(".");
        clazz.writeFile(thisFile.getAbsolutePath());
        clazz.detach();


        Target2 obj = new Target2();
        obj.exeStrings();
        obj.exeStringBuilder();
    }

}
