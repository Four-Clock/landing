package com.myself.asm;

import com.myself.logger.LoggerUtil;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * 功能描述: Agent
 *
 * @author linqin.zxl
 * @date 2021/5/8
 */
public class Agent {
    private static final String AGENT_CLASS_PREFIX = "com/myself/springboot/controller";

    public static void premain(String agentArgs, Instrumentation inst){
        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                if (className.startsWith(AGENT_CLASS_PREFIX)){
                    LoggerUtil.info(className);
                    ClassReader reader = new ClassReader(classfileBuffer);
                    ClassWriter writer = new ClassWriter(reader, 1);
                    ClassPrinter visitor = new ClassPrinter(writer);
                    reader.accept(visitor, 1);
                    return writer.toByteArray();
                }
                return null;
            }
        });
    }
}
