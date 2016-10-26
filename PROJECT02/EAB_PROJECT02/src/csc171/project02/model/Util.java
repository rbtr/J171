package csc171.project02.model;

import java.util.Calendar;
import java.util.Date;

/*
 * Util.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: PROJECT 02
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/11/15
 */

/**
 * This is a utility class for misc methods that don't quite fit anywhere else.
 */
public abstract class Util {

    /**
     * This method takes a long and returns the slash-separated (American) Date String
     * @param time is the long time
     * @return the Date as a String
     */
    public static String getFormattedDate(long time) {
        Date date = new Date();
        date.setTime(time);
        return getFormattedDate(date);
    }

    /**
     * This method take a Date object and returns the slash-separated (American) Date String
     * @param date is the Date object to parse
     * @return the Date as a String
     */
    public static String getFormattedDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return String.valueOf(calendar.get(Calendar.MONTH))
                + "/" + calendar.get(Calendar.DAY_OF_MONTH)
                + "/" + calendar.get(Calendar.YEAR);
    }
}
