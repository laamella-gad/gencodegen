package com.laamella.gencodegen.java;

import com.laamella.gencodegen.core.io.TestAggregator;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.nio.file.Files.*;
import static org.junit.Assert.assertEquals;

public class JavaFileTest {
    private final TestAggregator aggregator = new TestAggregator();

    @Test
    public void happyFlow() throws Exception {
        JavaFile file = new JavaFile("com.laamella.gencodegen.java", "JavaFileTest");
        file.imports
                .add(String.class)
                .add(Map.class)
                .add("bla.bla.*");

        ClassBody testClass = file.class_("public class JavaFileTest");
        testClass.fields.add("public static final int ABC=3;");
        testClass.method("@Test public void happyFlow()")
                .add("// TODO write test")
                .open("do")
                .add("// Nothing!")
                .close("while(true);");

        file.write(aggregator);
        assertLooksLike("happyFlow.expected", aggregator.generatedFiles.get(0).content);
    }

    private void assertLooksLike(String expectedFile, String actual) throws URISyntaxException, IOException {
        String expected = new String(readAllBytes(Paths.get(getClass().getResource("/" + expectedFile).toURI())), Charset.forName("UTF-8"));
        assertEquals(expected, actual);
    }

}