package com.laamella.gencodegen.java;

import java.io.File;
import java.io.OutputStream;

import com.laamella.gencodegen.core.Block;
import com.laamella.gencodegen.core.io.OutputStreamFactory;

public class JavaFile extends JavaBlock {
    public final Imports imports = new Imports();
    public final String packageName;
    public final String name;

    public JavaFile(final String packageName, final String fileName) {
        this.packageName = packageName;
        this.name = fileName;
        add("package %s;", packageName).ln();
        addObject(imports);
    }

    public ClassBody class_(String opener, Object... args) {
        ln().open(opener, args);
        final ClassBody classBody = new ClassBody(getIndent(), imports);
        addObject(classBody);
        close();
        return classBody;
    }

    public void write(final OutputStreamFactory outputDir) throws Exception {
        checkIndentationMatches();
        final String packageDir = packageName.replace('.', File.separatorChar);
        outputDir.stream(packageDir, name + ".java", outputStream -> outputStream.write(JavaFile.this.toString().getBytes("utf-8")));
    }

}
