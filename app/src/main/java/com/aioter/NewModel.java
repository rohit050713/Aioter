package com.aioter;

public class NewModel {

    Integer RoomLogo;
    String DeviceType;

    public NewModel(Integer RoomLogo, String DeviceType) {
        this.RoomLogo = RoomLogo;
        this.DeviceType = DeviceType;
    }

    public Integer getRoomLogo() {
        return RoomLogo;
    }

    public String getDeviceType() {
        return DeviceType;
    }
}
