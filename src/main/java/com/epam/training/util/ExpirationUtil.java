package com.epam.training.util;


import java.util.Calendar;
import java.util.Date;

public class ExpirationUtil {

    private static Date dateofExpiration;
    private static final int TIME_TO_LIVE = 5;

   static  {
        dateofExpiration = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateofExpiration);
        cal.add(cal.SECOND, TIME_TO_LIVE);
        dateofExpiration = cal.getTime();

    }


    public static boolean isExpired() {
        //  if the time to live is zero then it lives forever!
        if (dateofExpiration == null) {
            return false;
        }

        return dateofExpiration.before(new Date());
    }

}
