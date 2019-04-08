package com.frictionhacks.chatbox.DataModel;

import java.util.Date;

public class ChatRoomWord {
    private String mSender;
    private String mReceiver;
    private long date;

    public ChatRoomWord(String mSender, String mReceiver) {
        this.mSender = mSender;
        this.mReceiver = mReceiver;
        date=new Date().getTime();
    }

    public String getmSender() {
        return mSender;
    }

    public void setmSender(String mSender) {
        this.mSender = mSender;
    }

    public String getmReceiver() {
        return mReceiver;
    }

    public void setmReceiver(String mReceiver) {
        this.mReceiver = mReceiver;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
