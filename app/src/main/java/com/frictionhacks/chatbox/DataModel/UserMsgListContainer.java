package com.frictionhacks.chatbox.DataModel;

import java.util.ArrayList;

public class UserMsgListContainer {
    private ArrayList<UserMainWord> UserMsgList;

    public UserMsgListContainer(ArrayList<UserMainWord> userMsgList) {
        UserMsgList = new ArrayList<>(userMsgList);
    }

    public UserMsgListContainer() {
        UserMsgList = new ArrayList<>();
    }

    public ArrayList<UserMainWord> getUserMsgList() {
        UserMsgList=new ArrayList<>();
        return UserMsgList;
    }

    public void setUserMsgList(ArrayList<UserMainWord> userMsgList) {
        UserMsgList = userMsgList;
    }

    public void addUserChat(UserMainWord m) {
        UserMsgList.add(m);

    }

    public void removeUserChat(int i) {
        UserMsgList.remove(i);
    }
}
