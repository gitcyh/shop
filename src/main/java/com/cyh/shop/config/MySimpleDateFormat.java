package com.cyh.shop.config;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MySimpleDateFormat extends SimpleDateFormat {

    private StdDateFormat stdDateFormat = new StdDateFormat();

    public MySimpleDateFormat() {
        super("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public Date parse(String dateStr) throws ParseException {
        if (dateStr != null && !dateStr.contains("T")) {
            return super.parse(dateStr);
        }
        return stdDateFormat.parse(dateStr);
    }

    @Override
    public Object clone() {
        MySimpleDateFormat  other = (MySimpleDateFormat )super.clone();
        other.stdDateFormat  = new StdDateFormat();
        return other;
    }

}
