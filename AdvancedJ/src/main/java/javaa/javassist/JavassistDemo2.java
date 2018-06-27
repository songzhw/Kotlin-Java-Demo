package javaa.javassist;

import javassist.ClassPool;
import javassist.CtClass;
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

        CtMethod[] allMethods = clazz.getDeclaredMethods();

        for (CtMethod _method : allMethods) {
            String name = _method.getName();
            System.out.println("-- 1. method name = "+name);

            String _name = "_"+name;
            _method.setName(_name);

            StringBuilder sb = new StringBuilder();
            sb.append("{\n");
            sb.append("long start = System.nanoTime();\n");
            sb.append(_name+"($$);\n"); //执行_foo(). $$是指原来的所有参数
            sb.append("long end = System.nanoTime();\nSystem.out.println(\"szw javassit exec "+name+"() : \" + (end - start));\n");
            sb.append("}");

            CtMethod method = CtNewMethod.copy(_method, name, clazz, null);
            method.setBody(sb.toString());

            clazz.addMethod(method); //TODO 有个疑问, 这会不会是边循环边修改, 会不会有问题
        }

        for(CtMethod m : clazz.getDeclaredMethods()){
            System.out.println("-- 2. method name = "+m.getName());
        }

        clazz.writeFile();
        clazz.detach();




        Target2 obj = new Target2();
        obj.exeStrings();
        obj.exeStringBuilder();
    }

}
