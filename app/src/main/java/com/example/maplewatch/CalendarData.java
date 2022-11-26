package com.example.maplewatch;

import java.util.Calendar;

public class CalendarData
{
    public int hour;
    public int min;

    public int month;
    public int day;
    public int dayOfWeek;

    public CalendarData(Calendar calendar)
    {
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
    }
}
