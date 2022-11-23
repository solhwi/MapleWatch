package com.example.maplewatch;

import android.app.Activity;
import android.widget.TextView;

public class TimeViewController
{
    private TextView dateTxt, timeTxt;

    public TimeViewController(Activity activity)
    {
        dateTxt = (TextView)activity.findViewById(R.id.dateTxt);
        timeTxt = (TextView)activity.findViewById(R.id.timeTxt);
    }

    public void Show(int month, int day, int hour, int min)
    {
        dateTxt.setText(month + "월" + day + "일");
        timeTxt.setText(hour + "시" + min + "분");
    }
}
