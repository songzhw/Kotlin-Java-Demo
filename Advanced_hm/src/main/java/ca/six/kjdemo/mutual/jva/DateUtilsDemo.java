package ca.six.kjdemo.mutual.jva;

import ca.six.kjdemo.mutual.kt.DateUtils;

import java.util.Date;

class DateUtilsDemo {
    public static void main(String[] args) {
        String val = DateUtils.timeSince(new Date());
    }
}
