package com.yetanother;

public interface CommandLineParser {
    CommandLine parse(Options options, String[] args);
}
