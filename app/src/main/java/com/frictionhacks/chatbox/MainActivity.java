package com.frictionhacks.chatbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.frictionhacks.chatbox.Adapter.MainRecyclerAdapter;
import com.frictionhacks.chatbox.DataModel.UserMainWord;
import com.frictionhacks.chatbox.DataModel.UserMsgListContainer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
UserMsgListContainer userMsgListContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddData();
        RecyclerView rvContactList=findViewById(R.id.main_rv);
        LinearLayoutManager llmContactList=new LinearLayoutManager(getApplicationContext());
        rvContactList.setLayoutManager(llmContactList);
        rvContactList.setAdapter(new MainRecyclerAdapter(userMsgListContainer));

    }

    private void AddData() {
        ArrayList<UserMainWord> arrayList=new ArrayList<>();
        arrayList.add(new UserMainWord("shubham","last sg"));
        arrayList.add(new UserMainWord("shubham","last sg"));
        arrayList.add(new UserMainWord("shubham","last sg"));
        arrayList.add(new UserMainWord("shubham","last sg"));
        userMsgListContainer=new UserMsgListContainer(arrayList);

    }
}
