package com.wtown.suggest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static DateUtil du = new DateUtil();

    public static DateUtil getInstance() {
        return du;
    }

    private DateUtil() {

    }

    public String getCurrentDate(String format) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }
}
