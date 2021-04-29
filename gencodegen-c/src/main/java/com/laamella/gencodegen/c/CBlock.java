package com.laamella.gencodegen.c;

import com.laamella.gencodegen.core.Block;

public class CBlock extends Block<CBlock> {
    protected CBlock(int indent) {
        super(indent);
    }

    @Override
    protected CBlock newBlock(int indent) {
        return new CBlock(indent);
    }

    public void define(String s) {
        add("#define %s;", s);
    }

    /**
     * Add a one line statement, which means that a semi-colon is added to it.
     */
    public CBlock state(String s) {
        add("%s;", s);
        return this;
    }

    public CBlock lnopen() {
        return ln().add("{").in();
    }

    public CBlock open() {
        return add("{").in();
    }

    public CBlock lnopen(final String format, final Object... args) {
        return add(format, args).add("{").in();
    }

    public CBlock open(final String format, final Object... args) {
        return add(format + " {", args).in();
    }

    public CBlock close(final String format, final Object... args) {
        return out().add("} " + format, args);
    }

    public CBlock close() {
        return out().add("}");
    }

    public CBlock function(String opener, Object... args) {
        lnopen(opener, args);
        final CBlock body = block();
        close().ln();
        return body;
    }
}
