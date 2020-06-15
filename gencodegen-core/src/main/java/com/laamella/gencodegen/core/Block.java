package com.laamella.gencodegen.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * A block of code. It is indented to a certain amount and has a sequence of toStringable things inside.
 *
 * @param <T> the type of the class that inherits from Block. This sets the return types for chaining calls to that type.
 */
public abstract class Block<T extends Block<?>> {
	private static final Logger log = LoggerFactory.getLogger(Block.class);

	private final int originalIndent;
	private int indent;
	private final List<Object> content = new ArrayList<>();

	/**
	 * An internal constructor for use by the code generator classes themselves.
	 *
	 * @param indent the indentation level at which this block is supposed to render itself once toString is called.
	 */
	protected Block(final int indent) {
		this.indent = indent;
		this.originalIndent = indent;
	}

	/**
	 * Create a new block at indentation level 0.
	 */
	protected Block() {
		this(0);
	}

	/**
	 * Add a block to the content of this block.
	 *
	 * @return a block at the same indentation level as this block.
	 */
	public T block() {
		final T block = newBlock(getIndent());
		addObject(block);
		return block;
	}

	protected abstract T newBlock(int indent);

	protected boolean contains(Object o) {
		return content.contains(o);
	}

	/**
	 * @return this block with all its content, rendered to a string.
	 */
	@Override
	public String toString() {
		checkIndentationMatches();
		final StringBuilder block = new StringBuilder();
		for (final Object o : content) {
			block.append(o.toString());
		}
		return block.toString();
	}

	/**
	 * Add an object to the content. This object can still change, and will have its toString called only when this block has its toString called.
	 */
	public void addObject(Object o) {
		content.add(o);
	}

	/**
	 * Indent one step, and add static text with optional placeholders.
	 */
	public T in(final String format, final Object... args) {
		indent++;
		return add(format, args);
	}

	/**
	 * Add static text with optional placeholders.
	 *
	 * @param format the text as it is passed to String.format
	 * @param args   arguments as passed to String.format
	 */
	public T add(final String format, final Object... args) {
		final StringBuilder indentation = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			indentation.append("\t");
		}
		if (args.length == 0) {
			addObject(indentation + format + "\n");
		} else {
			addObject(indentation + format(format + "\n", args));
		}
		return tis();
	}

	/**
	 * Unindent one step, and add static text with optional placeholders.
	 */
	public T out(final String format, final Object... args) {
		indent--;
		return add(format, args);
	}

	protected final T tis() {
		return (T) this;
	}

	/**
	 * Unindent one step.
	 */
	public T out() {
		indent--;
		return tis();
	}

	/**
	 * Indent one step.
	 */
	public T in() {
		indent++;
		return tis();
	}

	/**
	 * Add a newline.
	 */
	public T ln() {
		return add("");
	}

	/**
	 * @return the current indent level.
	 */
	protected int getIndent() {
		return indent;
	}

	/**
	 * When this block has been finished, call this to see if the indent and unindent calls are balanced.
	 */
	protected void checkIndentationMatches() {
		if (indent > originalIndent) {
			log.warn("Indentation mismatch: {} indents too much.", indent - originalIndent);
		}
		if (indent < originalIndent) {
			log.warn("Indentation mismatch: {} indents too few.", originalIndent - indent);
		}
	}
}
