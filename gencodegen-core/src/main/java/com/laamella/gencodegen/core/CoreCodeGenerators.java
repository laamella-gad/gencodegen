package com.laamella.gencodegen.core;

public class CoreCodeGenerators {
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
