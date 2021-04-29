package com.laamella.gencodegen.c;

import com.laamella.gencodegen.core.UniqueList;

/**
 * The pragma block at the top of the file
 */
public class Pragmas extends UniqueList {
    /**
     * Add a #pragma
     *
     * @param pragma what follows #pragma
     */
    public Pragmas add(String pragma) {
        addString("#pragma %s;\n", pragma);
        return this;
    }
}
