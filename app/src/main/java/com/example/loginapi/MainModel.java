package com.example.loginapi;

import androidx.annotation.Nullable;

public class MainModel {
    Integer langlogo;
    String langDuo;
    String langRoom;
    public MainModel(Integer langlogo, String langDuo, String langRoom){
        this.langDuo = langDuo;
        this.langlogo= langlogo;
        this.langRoom = langRoom;
    }

    public Integer getLanglogo(){
        return langlogo;
    }

    public String getLangDuo(){
        return langDuo;
    }
    public String getLangRoom(){
        return langRoom;
    }
}
