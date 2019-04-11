package com.frictionhacks.chatbox.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.frictionhacks.chatbox.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatRoom extends AppCompatActivity {
LinearLayout ll;
ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        ll=findViewById(R.id.ll_chat_room_layout);
        scrollView=findViewById(R.id.sv_chat_room_msg_list);
    }

    private void addMessageBox(String msg,int type) {
        TextView textView=new TextView(ChatRoom.this);
        textView.setText(msg);
        textView.setAlpha(0);
        textView.setPadding(22,22,22,22);
        textView.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (type==1){
            lp.gravity= Gravity.START;
            textView.setBackground(getDrawable(R.drawable.ic_chat_icon));


        }
        else {
            lp.gravity=Gravity.END;
            textView.setBackground(getDrawable(R.drawable.ic_chat_icon));

        }
        textView.setLayoutParams(lp);
        ll.addView(textView);

        textView.animate().alpha(1).setDuration(500);

        scrollView.fullScroll(View.FOCUS_DOWN);

    }
    //to be removed
    public void show(View view){show();}
    public void show() {

        addMessageBox("HEllO",1);
        addMessageBox("HEllO",2);


    }
}
