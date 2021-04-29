package com.laamella.gencodegen.core;

import org.junit.jupiter.api.Test;

import static com.laamella.gencodegen.core.CoreCodeGenerators.capitalize;
import static com.laamella.gencodegen.core.CoreCodeGenerators.decapitalize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoreCodeGeneratorsTest {
    @Test
    public void whenCapitalizingAStringWithALowerCaseInitialLetterThenTheFirstLetterIsUppercased() {
        assertEquals("Abc", capitalize("abc"));
    }

    @Test
    public void whenCapitalizingAStringWithAnUpperCaseInitialLetterThenNothingHappens() {
        assertEquals("Abc", capitalize("Abc"));
    }

    @Test
    public void whenCapitalizingAnEmptyStringThenWeGetAnEmptyString() {
        assertEquals("", capitalize(""));
    }

    @Test
    public void whenDecapitalizingAStringWithALowerCaseInitialLetterThenNothingHappens() {
        assertEquals("abc", decapitalize("abc"));
    }

    @Test
    public void whenDecapitalizingAStringWithAnUpperCaseInitialLetterThenFirstLetterIsLowercased() {
        assertEquals("abc", decapitalize("Abc"));
    }

    @Test
    public void whenDecapitalizingAnEmptyStringThenWeGetAnEmptyString() {
        assertEquals("", decapitalize(""));
    }
}
