package com.laamella.gencodegen.java;

/**
 * The block just after starting a class. Here you can add fields with "addObject"
 */
public class Fields extends JavaBlock {
	public Fields(int indent) {
		super(indent);
	}

    /**
     * Add a field. Using this method prevents duplicate fields.
     */
	@Override
	public void addObject(Object o) {
		if(contains(o)){
			return;
		}
		super.addObject(o);
	}

}
