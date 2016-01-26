package com.laamella.gencodegen.java;


import com.laamella.gencodegen.core.Block;

public class Fields extends Block {
	public Fields(int indent) {
		super(indent);
	}

	@Override
	public void addObject(Object o) {
		if(contains(o)){
			return;
		}
		super.addObject(o);
	}

}
