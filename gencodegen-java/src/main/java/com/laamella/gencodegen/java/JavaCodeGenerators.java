package com.laamella.gencodegen.java;

import com.laamella.gencodegen.core.CoreCodeGenerators;

public class JavaCodeGenerators extends CoreCodeGenerators {
    public static String call(String methodName, Object... args) {
        final StringBuilder s = new StringBuilder(methodName + "(");
        boolean first = true;
        for (Object arg : args) {
            if (!first) {
                s.append(", ");
            }
            s.append(arg.toString());
            first = false;
        }
        return s.append(")").toString();
    }

    public static String thro(Class<? extends Throwable> exception, Object... args) {
        return call("throw new " + exception.getSimpleName(), args);
    }

    // TODO add getter
    // TODO add setter
}
