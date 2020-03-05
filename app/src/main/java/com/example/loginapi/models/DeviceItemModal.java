package com.example.loginapi.models;

public class DeviceItemModal {
    private String mDeviceName,mDeviceSerialNo,mSwitchNo;

    public DeviceItemModal(String deviceName,String deviceSerialNo,String switchNo){
        mDeviceName=deviceName;
        mDeviceSerialNo=deviceSerialNo;
        mSwitchNo=switchNo;
    }

    public void setmDeviceName(String mDeviceName) {
        this.mDeviceName = mDeviceName;
    }

    public void setmDeviceSerialNo(String mDeviceSerialNo) {
        this.mDeviceSerialNo = mDeviceSerialNo;
    }

    public void setmSwitchNo(String mSwitchNo) {
        this.mSwitchNo = mSwitchNo;
    }

    public String getmDeviceName() {
        return mDeviceName;
    }

    public String getmDeviceSerialNo() {
        return mDeviceSerialNo;
    }
    public String getmSwitchNo(){
        return mSwitchNo;
    }
}
