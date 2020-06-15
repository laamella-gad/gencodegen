package com.laamella.gencodegen.core;

/**
 * A block which disallows duplicate entries.
 */
public abstract class UniqueListBlock<T extends UniqueListBlock<?>> extends Block<T> {
    protected UniqueListBlock(int indent) {
        super(indent);
    }

    /**
     * Add a field. Using this method prevents duplicate fields.
     */
    @Override
    public void addObject(Object o) {
        if (contains(o)) {
            return;
        }
        super.addObject(o);
    }
}
