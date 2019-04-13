package com.frictionhacks.chatbox.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.frictionhacks.chatbox.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class ChatRoom extends AppCompatActivity {
    LinearLayout ll;
    ScrollView scrollView;
    private DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        ll = findViewById(R.id.ll_chat_room_layout);
        mdatabase= FirebaseDatabase.getInstance().getReference();
        scrollView = findViewById(R.id.sv_chat_room_msg_list);
        Button b = findViewById(R.id.ed_chat_room_msg_send);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        EditText sendMsg = findViewById(R.id.ed_chat_room_msg);
        String Msg = sendMsg.getText().toString().trim();

    }


    private void addMessageBox(String msg, int type) {
        TextView textView = new TextView(ChatRoom.this);
        textView.setText(msg);
        textView.setAlpha(0);
        textView.setPadding(22, 22, 22, 22);
        textView.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (type == 1) {
            lp.gravity = Gravity.START;
            textView.setBackground(getDrawable(R.drawable.ic_chat_icon));


        } else {
            lp.gravity = Gravity.END;
            textView.setBackground(getDrawable(R.drawable.ic_chat_icon));

        }
        textView.setLayoutParams(lp);
        ll.addView(textView);

        textView.animate().alpha(1).setDuration(500);

        scrollView.fullScroll(View.FOCUS_DOWN);

    }

}
