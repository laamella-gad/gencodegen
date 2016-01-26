package com.laamella.gencodegen.java;

import com.laamella.gencodegen.core.Block;

public class ClassBody extends JavaBlock {
    public final Fields fields;
    public final Imports imports;

    ClassBody(int indent, Imports imports) {
        super(indent);
        this.imports = imports;
        fields = new Fields(getIndent());
        addObject(fields);
        ln();
    }

    public Block method(String opener, Object... args) {
        open(opener, args);
        final Block methodBody = block();
        close().ln();
        return methodBody;
    }
}
