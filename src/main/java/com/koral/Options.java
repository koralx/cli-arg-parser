package com.koral;

import java.util.ArrayList;

public class Options {

    private final ArrayList<Option> options = new ArrayList<>();

    public Options() {}

    public void addOption(String shortOpt, String longOpt, boolean hasValue, String desc) {
        Option option = new Option(shortOpt, longOpt, hasValue,desc);
        options.add(option);
    }

    public ArrayList<Option> getOptions() {
        return options;
    }
}
