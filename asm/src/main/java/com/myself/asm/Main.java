package com.myself.asm;

import com.myself.logger.LoggerUtil;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import java.io.IOException;

/**
 * 功能描述: Main
 *
 * @author linqin.zxl
 * @date 2021/5/4
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String  clazz = "com.myself.asm.HelloWorld";
        ClassReader classReader = new ClassReader(clazz);
        int access = classReader.getAccess();
        LoggerUtil.info("#######access:"+access);
        String className = classReader.getClassName();
        LoggerUtil.info("#######className:"+className);
        ClassAdapter classAdapter =new ClassAdapter(new MyClassVisitor());
        classReader.accept(classAdapter,1);
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.hello();
    }

    static class MyClassVisitor implements ClassVisitor {

        private Attribute attribute;

        @Override
        public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
            LoggerUtil.info("#######visit:"+s);
        }

        @Override
        public void visitSource(String s, String s1) {
            LoggerUtil.info("#######visitSource:"+s);
        }

        @Override
        public void visitOuterClass(String s, String s1, String s2) {
            LoggerUtil.info("#######visitOuterClass:"+s);
        }

        @Override
        public AnnotationVisitor visitAnnotation(String s, boolean b) {
            String className = Type.getType(s).getClassName();
            try {
                Class.forName(className,false,Thread.currentThread().getContextClassLoader());
            }catch (Exception ex){

            }
            LoggerUtil.info("#######visitAnnotation:"+className);
            return null;
        }

        @Override
        public void visitAttribute(Attribute attribute) {
            LoggerUtil.info("#######visitAttribute:"+attribute);
        }

        @Override
        public void visitInnerClass(String s, String s1, String s2, int i) {
            LoggerUtil.info("#######visitInnerClass:"+s);
        }

        @Override
        public FieldVisitor visitField(int i, String s, String s1, String s2, Object o) {
            LoggerUtil.info("#######visitField:"+s);
            return null;
        }

        @Override
        public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
            LoggerUtil.info("#######visitMethod:"+s);
            return null;
        }

        @Override
        public void visitEnd() {
            LoggerUtil.info("#######visitEnd:");
        }
    }
}
