package com.koral;

public interface CommandLineParser {
    CommandLine parse(Options options, String[] args);
}
