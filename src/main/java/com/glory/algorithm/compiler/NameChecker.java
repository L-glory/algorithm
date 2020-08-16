package com.glory.algorithm.compiler;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner9;
import javax.tools.Diagnostic;

/**
 * 命名规范检查器
 *
 * @author Glory
 * @create 2020-05-28 13:49
 **/
public class NameChecker {

    private Messager messager;

    public NameChecker(ProcessingEnvironment environment) {
        Messager messager = environment.getMessager();
    }

    public void check(Element element) {

    }

    private class NameCheckScanner extends ElementScanner9<Void, Void> {

        // 检查类名称
        @Override
        public Void visitType(TypeElement e, Void aVoid) {
            scan(e.getTypeParameters(), aVoid);
            //checkCamelCase(e, true);
            return super.visitType(e, aVoid);
        }

        // 检查方法名称

        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.METHOD) {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "一个普通方法[" + name + "]不应该与类名称重复，避免与构造方法产生冲突");
                }
                //checkCamelCase(e, true);
            }
            return super.visitExecutable(e, aVoid);
        }
    }
}
