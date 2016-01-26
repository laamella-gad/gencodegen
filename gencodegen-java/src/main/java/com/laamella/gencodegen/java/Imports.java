package com.laamella.gencodegen.java;

import java.util.Set;
import java.util.TreeSet;

public class Imports {
	private final Set<String> imports = new TreeSet<String>();

	public void add(Class<?> classToImport){
		imports.add(classToImport.getName());
	}
	
	public void addStatic(Class<?> classToImport){
		imports.add("static "+classToImport.getName()+".*");
	}
	
	public void add(String classToImport){
		imports.add(classToImport);
	}
	
	@Override
	public String toString() {
		final StringBuffer stringBuffer = new StringBuffer();
		for (final String imp : imports) {
			stringBuffer.append(String.format("import %s;\n", imp));
		}
		return stringBuffer.toString();
	}
}
