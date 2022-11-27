package com.example.maplewatch;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CharacterSetter implements Runnable
{
    private CharacterInfoData currentData;
    private String currentNickname;

    private IDataShower[] controllers;

    private String serverURL = "https://localhost:7116/";

    public CharacterSetter(IDataShower[] _controllers, String nickName)
    {
        controllers = _controllers;
        currentNickname = nickName;
    }

    public String GetCharacterInfoByJson() throws IOException
    {
        URL url = new URL(serverURL + currentNickname);

        HttpsURLConnection myConnection =
                (HttpsURLConnection) url.openConnection();

        myConnection.setRequestMethod("GET");
        myConnection.setConnectTimeout(15000);
        myConnection.setReadTimeout(10000);
        myConnection.setDoInput(true);
        myConnection.setDoOutput(true);

        String result = "";

        if(IsConnectSuccess(myConnection.getResponseCode()))
        {
            InputStream is = myConnection.getInputStream();

            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            while ((result = br.readLine()) != null)
            {
                sb.append(result + '\n');
            }

            result = sb.toString();
        }
        else
        {
            Log.i("결과", myConnection.getResponseCode() + "Error");
        }

        return result;
    }

    public CharacterInfoData Make() throws IOException
    {
        String jsonCharacterInfoData = GetCharacterInfoByJson();

        Log.i("Json 캐릭터 데이터", jsonCharacterInfoData);


        return new CharacterInfoData();
    }

    private boolean IsConnectSuccess(int connectionCode)
    {
        return connectionCode == 200;
    }

    @Override
    public void run()
    {
        if(controllers == null)
            return;

        try
        {
            currentData = Make();

            for(IDataShower controller : controllers)
                controller.ShowCharacterInfo(currentData);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
