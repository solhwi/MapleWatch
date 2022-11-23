package com.example.maplewatch;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.time.*;

import java.util.Calendar;
import java.util.Date;

public class WatchActivity extends Activity
{
    private TextView characterNameTxt, jobTxt, levelTxt;
    private ImageView characterImg;

    private TimeRunner timeRunner;

    private String characterName, job;
    private int myLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        SetRunners();
    }

    private void SetRunners()
    {
        TimeViewController controller = new TimeViewController(this);
        timeRunner = new TimeRunner(controller);
    }

}
