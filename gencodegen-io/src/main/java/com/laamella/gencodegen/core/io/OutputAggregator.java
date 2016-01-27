package com.laamella.gencodegen.core.io;

import java.io.OutputStream;

/**
 * Output abstraction that supports writing files in extensive directory structures.
 */
public interface OutputAggregator {
	/**
	 * A target stream.
	 */
	interface Streamer {
		void stream(OutputStream outputStream) throws Exception;
	}

	/**
	 * Opens a stream, lets the streamer use it, then closes it.
	 * @param subDirectory a subdirectory in which the stream should be opened, as far as it makes sense for the factory implementation.
	 * @param name the name of the resource to be created and streamed to.
	 * @param streamer the user supplied code that uses the stream.
	 */
	void stream(String subDirectory, String name, Streamer streamer) throws Exception;
}
