package com.laamella.gencodegen.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ObjectContainer {
	private static final Logger log = LoggerFactory.getLogger(ObjectContainer.class);

	private final int originalIndent;
	protected final String blockOpener;
	protected final String blockCloser;
	private int indent;

	public ObjectContainer(final int indent, String blockOpener, String blockCloser) {
		this.indent = indent;
		this.originalIndent = indent;
		this.blockOpener = blockOpener;
		this.blockCloser = blockCloser;
	}

	public ObjectContainer in(final String format, final Object... args) {
		indent++;
		return add(format, args);
	}

	public ObjectContainer add(final String format, final Object... args) {
		final StringBuilder indentation = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			indentation.append("\t");
		}
		if (args.length == 0) {
			addObject(indentation + format + "\n");
		} else {
			addObject(indentation + String.format(format + "\n", args));
		}
		return this;
	}

	public ObjectContainer out(final String format, final Object... args) {
		indent--;
		return add(format, args);
	}

	public abstract void addObject(final Object o);

	public ObjectContainer out() {
		indent--;
		return this;
	}

	public ObjectContainer in() {
		indent++;
		return this;
	}

	public ObjectContainer ln() {
		return add("");
	}

	protected int getIndent() {
		return indent;
	}

	protected void checkIndentationMatches() {
		if (indent > originalIndent) {
			log.warn("Indentation mismatch: {} indents too much.", indent - originalIndent);
		}
		if (indent < originalIndent) {
			log.warn("Indentation mismatch: {} indents too few.", originalIndent - indent);
		}
	}

	public ObjectContainer open() {
		return add(blockOpener).in();
	}

	public ObjectContainer open(final String format, final Object... args) {
		return add(format + " " + blockOpener, args).in();
	}

	public ObjectContainer close(final String format, final Object... args) {
		return out().add(blockCloser + " " + format, args);
	}

	public ObjectContainer close() {
		return out().add(blockCloser);
	}
}
