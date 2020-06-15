package com.laamella.gencodegen.java;

import com.laamella.gencodegen.core.io.TestAggregator;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readAllBytes;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
				.add("int i=0;")
				.open("do")
				.add("i++;")
				.close("while(i<100);");

		file.write(aggregator);
		assertLooksLike("happyFlow.expected", aggregator.generatedFiles.get(0).content);
	}

	private void assertLooksLike(String expectedFile, String actual) throws URISyntaxException, IOException {
		String expected = Files.readString(Paths.get(getClass().getResource("/" + expectedFile).toURI()));
		assertEquals(expected, actual);
	}

}