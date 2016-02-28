package com.laamella.gencodegen.c;

import com.laamella.gencodegen.core.Block;
import com.laamella.gencodegen.core.io.OutputAggregator;

public class CFile extends CBlock {
	public final Block header;
	public final Pragmas pragmas = new Pragmas();
	public final Includes includes = new Includes();
	private final String subDirectory;
	private final String fileName;

	public CFile(String subDirectory, String fileName) {
		super(0);
		this.subDirectory = subDirectory;
		this.fileName = fileName;
		header = block();
		addObject(includes);
	}

	public CFile(String fileName) {
		this("", fileName);
	}

	/**
	 * Write the file to the file in the package directory where it belongs.
	 */
	public void write(final OutputAggregator aggregator) throws Exception {
		checkIndentationMatches();
		aggregator.stream(subDirectory, fileName, outputStream -> outputStream.write(CFile.this.toString().getBytes("utf-8")));
	}

}
