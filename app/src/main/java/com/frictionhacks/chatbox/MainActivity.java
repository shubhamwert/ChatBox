package com.frictionhacks.chatbox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.frictionhacks.chatbox.Activity.ChatRoom;
import com.frictionhacks.chatbox.Activity.LoginActivity;
import com.frictionhacks.chatbox.Adapter.MainRecyclerAdapter;
import com.frictionhacks.chatbox.DataModel.UserMainWord;
import com.frictionhacks.chatbox.DataModel.UserMsgListContainer;
import com.frictionhacks.chatbox.Interfaces.OnClickListeners;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements OnClickListeners {
    UserMsgListContainer userMsgListContainer;
    MainRecyclerAdapter UserMainAdapter;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    private DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);


        if (firebaseUser == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
            return;
        } else {
            String i = firebaseUser.getPhoneNumber();
            Toast.makeText(this, "" + i, Toast.LENGTH_SHORT).show();
            //AddData();
            RecyclerView rvContactList = findViewById(R.id.main_rv);
            LinearLayoutManager llmContactList = new LinearLayoutManager(getApplicationContext());
            rvContactList.setLayoutManager(llmContactList);
            UserMainAdapter = new MainRecyclerAdapter(userMsgListContainer);
            rvContactList.setAdapter(UserMainAdapter);
            mdatabase= FirebaseDatabase.getInstance().getReference("User");

            LoadContacts();

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

    }

    private void LoadContacts() {
        ValueEventListener postListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> snapshotIterable=dataSnapshot.getChildren();

                for (DataSnapshot aSnapshotIterable : snapshotIterable) {
                    UserMainWord userList=new UserMainWord();
                    userList = aSnapshotIterable.getValue(UserMainWord.class);
                    Log.d("blah blah", "onDataChange: "+aSnapshotIterable+" USer LIst "+userList);
                    userMsgListContainer.addUserChat(userList);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
Toast.makeText(MainActivity.this,"Process was cancelled",Toast.LENGTH_SHORT).show();
            }
        };
        mdatabase.child("users").addValueEventListener(postListener);
        UserMainAdapter.notifyDataSetChanged();
    }

    private void AddData() {
        ArrayList<UserMainWord> arrayList = new ArrayList<>();
        arrayList.add(new UserMainWord("shubham", "last sg"));
        arrayList.add(new UserMainWord("shubham", "last sg"));
        arrayList.add(new UserMainWord("shubham", "last sg"));
        arrayList.add(new UserMainWord("shubham", "last sg"));
        userMsgListContainer = new UserMsgListContainer(arrayList);

    }

    private void AddExtra() {

        UserMainAdapter.updateData(new UserMainWord("shubham", "1234"));
        UserMainAdapter.notifyDataSetChanged();
    }

    private void RemoveData(int i) {
        UserMainAdapter.removeData(i);
        UserMainAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnChatClick(View v, int position) {

    }

    @Override
    public void OnChatLongClick(View v, int position) {

    }

    public void next(View view) {
        Intent i = new Intent(MainActivity.this, ChatRoom.class);
        startActivity(i);
    }

    public void addContact(View view) {
        EditText editText=findViewById(R.id.ed_add_contact);
        String userId=editText.getText().toString();
        UserMainWord userMainWord=new UserMainWord(userId,""+ new Date().getTime());
        mdatabase.child("users").child(userId).setValue(userMainWord);
        LoadContacts();
    }
}
