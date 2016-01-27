package com.laamella.gencodegen.c;

import com.laamella.gencodegen.core.UniqueList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.String.format;

/**
 * The includes block at the top of the file.
 */
public class Includes extends UniqueList {
	/**
	 * Add an include statement for a class that is not on the classpath.
	 */
	public Includes add(String classToImport) {
		addString("#include %s;\n", classToImport);
		return this;
	}

	public Includes addSystem(String s) {
		add("<" + s + ">");
		return this;
	}

	public Includes addCustom(String s) {
		add("\"" + s + "\"");
		return this;
	}
}
