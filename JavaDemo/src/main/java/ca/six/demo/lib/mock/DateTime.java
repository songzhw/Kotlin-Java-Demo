package ca.six.demo.lib.mock;

/**
 * songzhw - 2016/3/31
 * Copyright 2016 Six.
 */
public class DateTime {
    public String time;

    public DateTime(String time) {
        this.time = time;
    }

    public String getNow() {
        time = "now";
        return time;
    }

}
