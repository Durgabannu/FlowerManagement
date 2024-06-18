package com.order.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String formatDateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    
    public static Date parseStringToDate(String dateString, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateString);
    }
}
