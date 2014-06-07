package com.github.ceFractal.gui;

import java.nio.file.Path;

public class Pj {

    private final Path path;

    public Pj(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public String getName() {
        return getPath().getFileName().toString();
    }

}
