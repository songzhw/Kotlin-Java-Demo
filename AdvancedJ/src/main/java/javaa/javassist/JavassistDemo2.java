package javaa.javassist;

import java.lang.reflect.Modifier;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class JavassistDemo2 {

    // 出错: no such field: start -- javaassit找不到局部变量
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        CtClass clazz = pool.get("javaa.javassist.Target2");
        if (clazz.isFrozen()) {
            clazz.defrost();
        }

        CtField start = new CtField(CtClass.longType, "start", clazz);
        start.setModifiers(Modifier.STATIC);
        clazz.addField(start);

        CtField end = new CtField(CtClass.longType, "end", clazz);
        end.setModifiers(Modifier.STATIC);
        clazz.addField(end);

        CtMethod[] allMethods = clazz.getDeclaredMethods();

        for (CtMethod method : allMethods) {
            String name = method.getName();
            method.insertBefore("start = System.nanoTime();\n");
            method.insertAfter("end = System.nanoTime();\nSystem.out.println(\"szw javassit exec "+name+"() : \" + (end - start));\n");
        }

        clazz.writeFile();
        clazz.detach();


        Target2 obj = new Target2();
        obj.exeStrings();
        obj.exeStringBuilder();
    }

}
