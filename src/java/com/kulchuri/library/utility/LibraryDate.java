package com.kulchuri.library.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LibraryDate {

    private LibraryDate() {

    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static Long getDays(String startDate, String endDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date start = format.parse(startDate);
        java.util.Date end = format.parse(endDate);
        return -((start.getTime() - end.getTime()) / (24 * 60 * 60 * 1000));
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getDays("2018-12-22", "2018-12-25"));
        System.out.println(getCurrentDate());
    }
}
