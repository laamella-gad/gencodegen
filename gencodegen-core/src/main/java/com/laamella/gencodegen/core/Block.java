package com.laamella.gencodegen.core;

import java.util.ArrayList;
import java.util.List;

public class Block extends ObjectContainer {
    private final List<Object> content = new ArrayList<Object>();

    public Block(final int indent) {
        super(indent);
    }

    public Block() {
        super(0);
    }

    public Block block() {
        final Block block = new Block(getIndent());
        addObject(block);
        return block;
    }
    
    protected boolean contains(Object o){
    	return content.contains(o);
    }

    @Override
    public String toString() {
        checkIndentationMatches();
        final StringBuilder block = new StringBuilder();
        for (final Object o : content) {
            block.append(o.toString());
        }
        return block.toString();
    }

	@Override
	public void addObject(Object o) {
		content.add(o);
	}
}
