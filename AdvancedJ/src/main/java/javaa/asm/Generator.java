package javaa.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;


class A extends ClassAdapter {

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

class B extends MethodAdapter {

    public B(MethodVisitor mv) {
        super(mv);
    }

    @Override
    public void visitCode() {
        visitMethodInsn(Opcodes.INVOKESTATIC, "SecurityChecker", "check", "()V");
    }
}

class Generator {
    public static void main(String[] args) throws Exception{

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        A classAdapter = new A(cw);

        ClassReader cr = new ClassReader("Account");
        cr.accept(classAdapter, ClassReader.SKIP_DEBUG);

        byte[] data = cw.toByteArray();
        File file = new File("Account.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
    }
}
