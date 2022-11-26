package com.example.maplewatch;

import java.util.Calendar;

public class TimeRunner implements Runnable
{
    private IDataShower dataShower;

    private Calendar myCalender;
    private CalendarData currentData;

    private static int THREAD_SLEEP_MILLI_TIME = 500;

    public TimeRunner(IDataShower controller)
    {
        myCalender = Calendar.getInstance();
        dataShower = controller;
    }

    @Override
    public void run()
    {
        while(!Thread.currentThread().isInterrupted())
        {
            try
            {
                UpdateDateTime();
                RefreshDateTime();

                Thread.sleep(THREAD_SLEEP_MILLI_TIME);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void UpdateDateTime()
    {
        long now = System.currentTimeMillis();
        myCalender.setTimeInMillis(now);

        currentData = new CalendarData(myCalender);
    }

    private void RefreshDateTime()
    {
        if(currentData == null)
            return;

        dataShower.ShowCalendarInfo(currentData);
    }
}
