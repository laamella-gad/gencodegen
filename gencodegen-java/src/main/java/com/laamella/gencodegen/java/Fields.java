package com.laamella.gencodegen.java;

import com.laamella.gencodegen.core.UniqueListBlock;

/**
 * The block just after starting a class. Here you can add fields with "addObject"
 */
public class Fields extends UniqueListBlock<Fields> {
	public Fields(int indent) {
		super(indent);
	}

	@Override
	protected Fields newBlock(int indent) {
		return new Fields(indent);
	}

}
