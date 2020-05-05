package com.zerasi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static int getHoursDateToDate(String date1, String date2) {
        try {
            SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date fromDate = simpleFormat.parse(date1);
            Date toDate = simpleFormat.parse(date2);
            long from = fromDate.getTime();
            long to = toDate.getTime();
            int returnInt = (int) ((to - from)/(1000 * 60 * 60));
            int remain = (int) ((to - from)%(1000 * 60 * 60));
            if(remain > 0){
                return returnInt + 1;
            }
            return returnInt;
        }catch (ParseException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.getHoursDateToDate("2020-05-07 12:00","2020-05-07 13:00"));
    }
}
