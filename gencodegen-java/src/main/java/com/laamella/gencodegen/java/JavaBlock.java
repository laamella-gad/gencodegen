package com.laamella.gencodegen.java;

import com.laamella.gencodegen.core.Block;

public class JavaBlock extends Block {
	public JavaBlock() {
		super("{", "}");
	}

	public JavaBlock(int indent) {
		super(indent, "{", "}");
	}
}
