package javaa.asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

import jdk.internal.org.objectweb.asm.Opcodes;

public class AsmDemo {
}

class Account{
    public void act(){
        System.out.println("Account act()");
    }
}

class SecurityChecker{
    public static void check(){
        System.out.println("SecurityChecker check()");
    }
}

class A extends ClassAdapter{

    public A(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions); //cv是父类成员, protected
        MethodVisitor wrapped = mv;
        if(mv != null){
            if("act".equals(name)){
                wrapped = new B(mv);
            }
        }
        return wrapped;
    }
}

class B extends MethodAdapter{

    public B(MethodVisitor mv) {
        super(mv);
    }

    @Override
    public void visitCode() {
        visitMethodInsn(Opcodes.INVOKESTATIC, "SecurityChecker", "check", "()V");
    }
}
