package com.yetanother;

import java.util.HashMap;

public class CommandLine {

    private final HashMap<String,String> args;

    CommandLine () {
        args = new HashMap<>();
    }

    public void addOption(String arg) {
        args.put(arg,arg);
    }

    public void addOption(String arg, String value) {
        args.put(arg,value);
    }

    public boolean containsOption(String arg) {
        return args.containsKey(arg);
    }

    public String getOptionValue(String arg) {
        return args.get(arg);
    }
}
