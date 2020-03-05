package com.example.loginapi.models;

import com.example.loginapi.R;

public enum ModelObject {

    SLIDE1(R.string.slide1, R.layout.tutorial_slide1),
    SLIDE2(R.string.slide2, R.layout.tutorial_slide2),
    SLIDE3(R.string.slide3, R.layout.tutorial_slide3);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}