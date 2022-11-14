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
        SetMyCharacterBtn();

        setContentView(R.layout.activity_main);
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
        if(nickName.length() > 6 || nickName.length() < 1)
            return false;

        if(nickName == null)
            return false;

        return true;
    }
}