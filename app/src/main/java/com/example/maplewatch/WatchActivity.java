package com.example.maplewatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WatchActivity extends Activity
{
    private Thread timeThread, characterThread;
    private Runnable timeRunner, characterSetter;

    private Intent currentIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        StartTimeRunner();
        StartCharacterSetter();
    }

    @Override
    protected void onDestroy()
    {
        timeThread.interrupt();
        characterThread.interrupt();
        super.onDestroy();
    }

    private void StartTimeRunner()
    {
        timeRunner = new TimeRunner(new TextViewController(this));

        timeThread = new Thread(timeRunner);
        timeThread.start();
    }

    private void StartCharacterSetter()
    {
        if(currentIntent == null)
            currentIntent = getIntent();

        String currentNickName = currentIntent.getStringExtra("nickname");

        IDataShower[] dataShowers = { new ImageViewController(this), new TextViewController(this) };

        characterSetter = new CharacterSetter(dataShowers, currentNickName);

        characterThread = new Thread(characterSetter);
        characterThread.start();
    }

}
