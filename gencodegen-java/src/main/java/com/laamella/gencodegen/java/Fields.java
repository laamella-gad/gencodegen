package com.laamella.gencodegen.java;

public class Fields extends JavaBlock {
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
