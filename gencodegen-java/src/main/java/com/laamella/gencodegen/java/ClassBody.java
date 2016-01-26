package com.laamella.gencodegen.java;

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

    public JavaBlock method(String opener, Object... args) {
        open(opener, args);
        final JavaBlock methodBody = block();
        close().ln();
        return methodBody;
    }
}
