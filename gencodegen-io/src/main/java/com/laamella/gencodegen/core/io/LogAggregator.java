package com.laamella.gencodegen.core.io;

/**
 * Streams everything to System.out, meant for debugging.
 */
public class LogAggregator implements OutputAggregator {
    public void stream(String subDirectory, String name, Streamer streamer) throws Exception {
        System.out.println("=== " + subDirectory + name + " ===");
        streamer.stream(System.out);
    }
}
