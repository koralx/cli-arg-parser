package com.koral;

public class Option {

    private final String shortArgName;
    private final String fullArgName;
    private final boolean hasValue;
    private final String description;

    public Option(String shortArgName, String fullArgName, boolean hasValue, String description) {
        this.shortArgName = shortArgName;
        this.fullArgName = fullArgName;
        this.hasValue = false;
        this.description = description;
    }

    public String getShortArgName() {
        return shortArgName;
    }
    public String getFullArgName() {
        return fullArgName;
    }
    public boolean hasValue() {return hasValue;}
    public String getDescription() {
        return description;
    }
}
