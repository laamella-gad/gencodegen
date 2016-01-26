package com.laamella.gencodegen.core;

public class TestBlock extends Block<TestBlock> {
    public TestBlock(int indent) {
        super(indent);
    }

    @Override
    protected TestBlock newBlock(int indent) {
        return new TestBlock(indent);
    }
}
