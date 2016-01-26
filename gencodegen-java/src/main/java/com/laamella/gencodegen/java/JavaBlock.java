package com.laamella.gencodegen.java;

import com.laamella.gencodegen.core.Block;

public class JavaBlock extends Block<JavaBlock> {
    public JavaBlock() {
    }

    @Override
    protected JavaBlock newBlock(int indent) {
        return new JavaBlock(indent);
    }

    public JavaBlock(int indent) {
        super(indent);
    }

    public JavaBlock open() {
		return add("{").in();
	}

	public JavaBlock open(final String format, final Object... args) {
		return add(format + " {", args).in();
	}

	public JavaBlock close(final String format, final Object... args) {
		return out().add("} " + format, args);
	}

	public JavaBlock close() {
		return out().add("}");
	}

}
