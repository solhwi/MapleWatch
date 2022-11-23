package com.example.maplewatch;
import android.widget.TextView;

import java.util.Calendar;

public class TimeRunner implements Runnable
{
    private Calendar myCalender;
    private int month, day, hour, min;

    private TimeViewController viewController;

    public TimeRunner(TimeViewController controller)
    {
        myCalender = Calendar.getInstance();
        viewController = controller;
    }

    @Override
    public void run()
    {
        UpdateDateTime();
        RefreshDateTime();
    }

    private void UpdateDateTime()
    {
        long now = System.currentTimeMillis();
        myCalender.setTimeInMillis(now);

        hour = myCalender.get(Calendar.HOUR_OF_DAY);
        min = myCalender.get(Calendar.MINUTE);
        day = myCalender.get(Calendar.DAY_OF_MONTH);
        month = myCalender.get(Calendar.MONTH);
    }

    private void RefreshDateTime()
    {
        viewController.Show(month, day, hour, min);
    }
}
