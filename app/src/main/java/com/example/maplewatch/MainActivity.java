package com.example.maplewatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maplewatch.databinding.ActivityMainBinding;

import java.util.regex.Pattern;

public class MainActivity extends Activity
{
    private Intent watchIntent; // 시계 화면

    private Button getMyCharacterBtn; // 캐릭터 정보 가져오기 버튼
    private EditText inputField; // 캐릭터 이름 받는 곳, 이 이름을 Intent를 거쳐서 WatchActivity로 넘겨야 함

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        watchIntent = new Intent(getApplicationContext(), WatchActivity.class);
        setContentView(R.layout.activity_main);

        inputField = (EditText)findViewById(R.id.inputField);
        SetMyCharacterBtn();
    }

    private void SetMyCharacterBtn()
    {
        getMyCharacterBtn = (Button)findViewById(R.id.GetMyCharacterBtn);
        getMyCharacterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String nickname = inputField.getText().toString();

                if(!IsValidNickname(nickname))
                {
                    ShowToastMessage("올바른 닉네임을 입력해주세요.");
                    return;
                }

                watchIntent.putExtra("nickname", nickname);
                startActivity(watchIntent);
            }
        });
    }

    private void ShowToastMessage(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private boolean IsValidNickname(String nickName)
    {
        if(nickName == null)
            return false;

        // 닉네임은 한글, 영어, 숫자로만 이루어짐
        if(!IsAlphaOrNumberOrKorean(nickName))
            return false;

        // 닉네임은 1 ~ 12 바이트
        if(!IsValidLength(nickName))
            return false;

        return true;
    }

    private boolean IsValidLength(String input)
    {
        int wordCount = 0;

        for(int i = 0; i < input.length(); i++)
        {
            char el = input.charAt(i);

            if(Character.isAlphabetic(el) || Character.isDigit(el)) // 영어나 숫자
            {
                wordCount++;
            }
            else if(Character.getType(el) == 5) // 한글이 5라고 함
            {
                wordCount += 2;
            }
        }

        return wordCount <= 12 && wordCount >= 1;
    }

    private boolean IsAlphaOrNumberOrKorean(String input)
    {
        boolean flag = Pattern.matches("^[a-zA-Z0-9가-힣]*$", input);
        return flag;
    }
}