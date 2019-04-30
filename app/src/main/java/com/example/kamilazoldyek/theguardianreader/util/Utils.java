package com.example.kamilazoldyek.theguardianreader.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {

    public static String DateFormat(String date){



        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.UK);
        Date newDate = null;
        try {
            newDate = format.parse(date);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        format = new SimpleDateFormat("EEEE, MMMM dd, yyyy 'at' HH:mm", Locale.UK);
        String formatedDate = format.format(newDate);

        return formatedDate;
    }


}
