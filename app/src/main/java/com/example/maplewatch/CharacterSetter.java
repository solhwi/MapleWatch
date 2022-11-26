package com.example.maplewatch;

public class CharacterSetter
{
    CharacterInfoData currentData;

    IDataShower[] controllers;

    public CharacterSetter(IDataShower[] _controllers, String nickName)
    {
        controllers = _controllers;

        // 변동되는 데이터가 아니므로 생성자에서 해결
        currentData = Make(nickName);
    }

    public CharacterInfoData Make(String nickname)
    {
        // 여기서 웹과 통신한다.
        return new CharacterInfoData();
    }

    public void Start()
    {
        if(controllers == null)
            return;

        for(IDataShower controller : controllers)
        {
            controller.ShowCharacterInfo(currentData);
        }
    }
}
