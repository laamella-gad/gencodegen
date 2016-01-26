package com.laamella.gencodegen.core;

import java.util.List;

public class CoreCodeGenerators {
    public static String join(String separator, List<String> args){
        final StringBuilder s = new StringBuilder();
        boolean first = true;
        for (Object arg : args) {
            if (!first) {
                s.append(separator);
            }
            s.append(arg.toString());
            first = false;
        }
        return s.toString();
    }
    public static String capitalize(final String string) {
        if (string.length() == 0) {
            return string;
        }
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static String decapitalize(String string) {
        if (string.length() == 0) {
            return string;
        }
        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }
}
