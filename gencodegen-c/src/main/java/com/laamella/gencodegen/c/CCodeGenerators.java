package com.laamella.gencodegen.c;

import com.laamella.gencodegen.core.CoreCodeGenerators;

public class CCodeGenerators extends CoreCodeGenerators {
	public static String call(String function, Object... args) {
		final StringBuilder s = new StringBuilder(function + "(");
		join(s, ", ", args);
		return s.append(")").toString();
	}

	/**
	 * Double-quote a string
	 */
	public static String q(String unquoted) {
		return "\"" + unquoted + "\"";
	}
}
