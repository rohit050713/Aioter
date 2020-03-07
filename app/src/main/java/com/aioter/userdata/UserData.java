package com.aioter.userdata;

public class UserData {
    String roomName;
    String whichIconSelected;

    UserData(String roomName, String whichIconSelected) {
        this.roomName = roomName;
        this.whichIconSelected = whichIconSelected;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setWhichIconSelected(String whichIconSelected) {
        this.whichIconSelected = whichIconSelected;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getWhichIconSelected() {
        return whichIconSelected;
    }
}
