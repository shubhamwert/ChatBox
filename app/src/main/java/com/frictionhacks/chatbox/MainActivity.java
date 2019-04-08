package com.frictionhacks.chatbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.frictionhacks.chatbox.Adapter.MainRecyclerAdapter;
import com.frictionhacks.chatbox.DataModel.UserMainWord;
import com.frictionhacks.chatbox.DataModel.UserMsgListContainer;
import com.frictionhacks.chatbox.Interfaces.OnClickListeners;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListeners {
UserMsgListContainer userMsgListContainer;
    MainRecyclerAdapter UserMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddData();
        RecyclerView rvContactList=findViewById(R.id.main_rv);
        LinearLayoutManager llmContactList=new LinearLayoutManager(getApplicationContext());
        rvContactList.setLayoutManager(llmContactList);
        UserMainAdapter = new MainRecyclerAdapter(userMsgListContainer);
        rvContactList.setAdapter(UserMainAdapter);
        UserMainAdapter.setOnClickListeners(new OnClickListeners() {
            @Override
            public void OnChatClick(View v, int position) {
                Toast.makeText(MainActivity.this, "Chat clicked", Toast.LENGTH_SHORT).show();
                AddExtra();
            }

            @Override
            public void OnChatLongClick(View v, int position) {
                Toast.makeText(MainActivity.this, "Chat long clicked", Toast.LENGTH_SHORT).show();
                RemoveData(position);
            }
        });

    }

    private void AddData() {
        ArrayList<UserMainWord> arrayList=new ArrayList<>();
        arrayList.add(new UserMainWord("shubham","last sg"));
        arrayList.add(new UserMainWord("shubham","last sg"));
        arrayList.add(new UserMainWord("shubham","last sg"));
        arrayList.add(new UserMainWord("shubham","last sg"));
        userMsgListContainer=new UserMsgListContainer(arrayList);

    }
private void AddExtra(){

    UserMainAdapter.updateData(new UserMainWord("shubham","1234"));
    UserMainAdapter.notifyDataSetChanged();
}
private void RemoveData(int i){
        UserMainAdapter.removeData(i);
    UserMainAdapter.notifyDataSetChanged();
}
    @Override
    public void OnChatClick(View v, int position) {

    }

    @Override
    public void OnChatLongClick(View v, int position) {

    }
}
