package com.laamella.gencodegen.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlockTest {
    @Test
    public void x(){
        TestBlock testBlock = new TestBlock(0);
        assertEquals("", testBlock.toString());
    }
}