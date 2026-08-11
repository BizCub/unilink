package io.github.bizcub.unilink.config;

public class Pair {
    public String from = "";
    public String to = "";

    @Override
    public String toString() {
        return from + " -> " + to;
    }
}
