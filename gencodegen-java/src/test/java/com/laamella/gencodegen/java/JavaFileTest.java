package com.laamella.gencodegen.java;

import com.laamella.gencodegen.core.io.SystemOutputStreamFactory;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class JavaFileTest {
	@Test
	public void happyFlow() throws Exception {
		JavaFile javaFileTest = new JavaFile("com.laamella.gencodegen.java", "JavaFileTest");
		javaFileTest
				.imports
				.add(String.class)
				.add(Map.class)
				.add("bla.bla.*");

		javaFileTest.add("public static final int ABC=3;");

		javaFileTest
				.class_("public class JavaFileTest")
				.method("@Test public void happyFlow()")
				.add("// TODO write test")
				.open("do")
				.add("// Nothing!")
				.close("while(true)");

		javaFileTest.write(new SystemOutputStreamFactory());
		assertLooksLike(javaFileTest, "JavaFileTest.expected");
	}

	private void assertLooksLike(JavaFile javaFileTest, String s) {

	}

}