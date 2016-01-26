package com.laamella.gencodegen.java;

import java.util.Set;
import java.util.TreeSet;

import static java.lang.String.*;

/**
 * The imports block, just after the package declaration.
 */
public class Imports {
	private final Set<String> imports = new TreeSet<String>();

    /**
     * Add an import statement for a class.
     */
	public Imports add(Class<?> classToImport) {
		imports.add(classToImport.getName());
		return this;
	}

    /**
     * Add an "import static" statement for a class.
     */
	public Imports addStatic(Class<?> classToImport) {
		imports.add("static " + classToImport.getName() + ".*");
		return this;
	}

    /**
     * Add an import statement for a class that is not on the classpath.
     */
	public Imports add(String classToImport) {
		imports.add(classToImport);
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder imports = new StringBuilder();
		for (final String imp : this.imports) {
			imports.append(format("import %s;\n", imp));
		}
		return imports.toString();
	}
}
