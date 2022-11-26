package com.example.maplewatch;

import android.app.Activity;
import android.widget.TextView;

public class TextViewController implements IDataShower
{
    private TextView dateTxt, timeTxt;
    private TextView characterNameTxt, jobTxt, levelTxt;

    public TextViewController(Activity activity)
    {
        dateTxt = (TextView)activity.findViewById(R.id.dateTxt);
        timeTxt = (TextView)activity.findViewById(R.id.timeTxt);

        characterNameTxt = (TextView)activity.findViewById(R.id.characterNameTxt);
        jobTxt = (TextView)activity.findViewById(R.id.jobTxt);
        levelTxt = (TextView)activity.findViewById(R.id.levelTxt);
    }

    @Override
    public void ShowCharacterInfo(CharacterInfoData data)
    {
        if(data == null)
            return;

        characterNameTxt.setText(data.characterName);
        jobTxt.setText(data.job);
        levelTxt.setText(Integer.toString(data.myLevel));
    }

    @Override
    public void ShowCalendarInfo(CalendarData data)
    {
        if(data == null)
            return;

        dateTxt.setText(data.month + "월" + data.day + "일");
        timeTxt.setText(data.hour + "시" + data.min + "분");
    }
}
