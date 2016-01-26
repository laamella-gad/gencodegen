package com.laamella.gencodegen.core.io;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Makes streams to files.
 */
public class FileOutputStreamFactory implements OutputStreamFactory {
	private final File outputDirectory;

	public FileOutputStreamFactory(File outputDirectory) {
		this.outputDirectory = outputDirectory;
		outputDirectory.mkdirs();
	}

	public void stream(String subDirectory, String name, Streamer streamer) throws Exception {
		File targetDirectory = new File(outputDirectory, subDirectory);
		targetDirectory.mkdirs();
		final File file = new File(targetDirectory, name);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		try {
			streamer.stream(fileOutputStream);
		} finally {
			fileOutputStream.close();
		}
	}
}
