package com.frictionhacks.chatbox.DataModel;

public class UserMainWord {
    private String mName;
    private String mMessage;

    public UserMainWord(String mName, String mMessage) {
        this.mName = mName;
        this.mMessage = mMessage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
