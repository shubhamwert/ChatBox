package com.frictionhacks.chatbox.DataModel;

import java.util.ArrayList;

public class UserMsgListContainer {
    private ArrayList<UserMainWord> UserMsgList;

    public UserMsgListContainer(ArrayList<UserMainWord> userMsgList) {
        UserMsgList = new ArrayList<>(userMsgList);
    }

    public ArrayList<UserMainWord> getUserMsgList() {
        return UserMsgList;
    }

    public void setUserMsgList(ArrayList<UserMainWord> userMsgList) {
        UserMsgList = userMsgList;
    }

    public UserMsgListContainer() {
        UserMsgList = new ArrayList<>();
    }
}
