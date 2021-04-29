package com.laamella.gencodegen.core.io;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Streams everything to Strings, meant for unit testing.
 */
public class TestAggregator implements OutputAggregator {
    public final List<GeneratedFile> generatedFiles = new ArrayList<>();

    public void stream(String subDirectory, String name, Streamer streamer) throws Exception {
        try (final ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            streamer.stream(outputStream);
            String content = outputStream.toString("utf-8");
            generatedFiles.add(new GeneratedFile(subDirectory, name, content));
        }
    }

    public static class GeneratedFile {
        public final String subDirectory;
        public final String name;
        public final String content;

        public GeneratedFile(String subDirectory, String name, String content) {
            this.subDirectory = subDirectory;
            this.name = name;
            this.content = content;
        }
    }
}
