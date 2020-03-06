package com.example.loginapi.models;

public class RunningStateDeviceItemModal {
    private String mDeviceName;
    private int mDeviceIcon;

    public RunningStateDeviceItemModal(String deviceName, int deviceIcon) {
        mDeviceName = deviceName;
        mDeviceIcon = deviceIcon;
    }

    public void setmDeviceName(String mDeviceName) {
        this.mDeviceName = mDeviceName;
    }

    public void setDeviceIcon(int mDeviceIcon) {
        this.mDeviceIcon = mDeviceIcon;
    }


    public String getmDeviceName() {
        return mDeviceName;
    }

    public int getmDeviceIcon() {
        return mDeviceIcon;
    }

}