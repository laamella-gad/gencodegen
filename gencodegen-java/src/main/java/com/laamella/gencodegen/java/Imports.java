package com.laamella.gencodegen.java;

import java.util.Set;
import java.util.TreeSet;

import static java.lang.String.*;

public class Imports {
	private final Set<String> imports = new TreeSet<String>();

	public Imports add(Class<?> classToImport) {
		imports.add(classToImport.getName());
		return this;
	}

	public Imports addStatic(Class<?> classToImport) {
		imports.add("static " + classToImport.getName() + ".*");
		return this;
	}

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
