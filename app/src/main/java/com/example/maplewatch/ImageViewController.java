package com.example.maplewatch;

import android.app.Activity;
import android.widget.ImageView;

public class ImageViewController implements IDataShower
{
    private ImageView characterImg;

    public ImageViewController(Activity activity)
    {
        characterImg = (ImageView)activity.findViewById(R.id.characterImg);
    }

    @Override
    public void ShowCharacterInfo(CharacterInfoData data) {
        if(data == null)
            return;
    }

    @Override
    public void ShowCalendarInfo(CalendarData data) {
        if(data == null)
            return;
    }
}
