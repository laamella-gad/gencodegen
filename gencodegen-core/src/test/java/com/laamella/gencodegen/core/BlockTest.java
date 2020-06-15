package com.laamella.gencodegen.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockTest {
    @Test
    public void x(){
        TestBlock testBlock = new TestBlock(0);
        assertEquals("", testBlock.toString());
    }
}