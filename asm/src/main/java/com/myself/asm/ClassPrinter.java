package com.myself.asm;


import com.myself.logger.LoggerUtil;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * 功能描述: ClassPrinter
 *
 * @author linqin.zxl
 * @date 2021/5/8
 */
public class ClassPrinter extends ClassVisitor {
    public ClassPrinter(ClassVisitor classVisitor) {
        super(Opcodes.ASM4, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        LoggerUtil.info(name + " extends " + superName + " {");
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        LoggerUtil.info(" " + name + desc);
        return super.visitMethod(access, name, desc, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        LoggerUtil.info("}");
        super.visitEnd();
    }
}
