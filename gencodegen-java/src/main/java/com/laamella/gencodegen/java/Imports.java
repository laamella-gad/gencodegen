package com.laamella.gencodegen.java;

import com.laamella.gencodegen.core.UniqueList;

import java.util.Set;
import java.util.TreeSet;

import static java.lang.String.*;

/**
 * The imports block, just after the package declaration.
 */
public class Imports extends UniqueList {
    /**
     * Add an import statement for a class.
     */
	public Imports add(Class<?> classToImport) {
		add(classToImport.getName());
		return this;
	}

    /**
     * Add an "import static" statement for a class.
     */
	public Imports addStatic(Class<?> classToImport) {
		add("static " + classToImport.getName() + ".*");
		return this;
	}

    /**
     * Add an import statement for a class that is not on the classpath.
     */
	public Imports add(String classToImport) {
		addString(format("import %s;\n", classToImport));
		return this;
	}
}
