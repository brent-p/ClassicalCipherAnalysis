package com.ClassyCrypt.Utils;

import java.io.BufferedReader;
import java.util.List;

/**
 * Name:brentparish
 * Created: 24/03/2015
 */
public class File {
    public String path;
    public List<String> lines;
    public BufferedReader buffer;

    public File()
    {

    }

    public File(String path) {
        this.path = path;
    }

    public File(String path, List<String> lines) {
        this.path = path;
        this.lines = lines;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public BufferedReader getBuffer() {
        return buffer;
    }

    public void setBuffer(BufferedReader buffer) {
        this.buffer = buffer;
    }
}
