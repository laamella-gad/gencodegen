package com.laamella.gencodegen.core.io;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Streams everything to files in their respective subdirectories.
 */
public class FileOutputAggregator implements OutputAggregator {
	private final File outputDirectory;

	public FileOutputAggregator(File outputDirectory) {
		this.outputDirectory = outputDirectory;
		outputDirectory.mkdirs();
	}

	public void stream(String subDirectory, String name, Streamer streamer) throws Exception {
		File targetDirectory = new File(outputDirectory, subDirectory);
		targetDirectory.mkdirs();
		final File file = new File(targetDirectory, name);
		try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
			streamer.stream(fileOutputStream);
		}
	}
}
