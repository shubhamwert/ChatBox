package com.frictionhacks.chatbox.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.frictionhacks.chatbox.Fragment.SignUpFragment;
import com.frictionhacks.chatbox.R;

public class LoginActivity extends AppCompatActivity {
boolean b=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignUpFragment signUpFragment=new SignUpFragment();
        FragmentManager l=getSupportFragmentManager();
        FragmentTransaction ft=l.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.fl_login_sign_options,signUpFragment);
        ft.commit();
      change();


    }

    public void change(View view){
        change();
    }
    public void change() {
     SignUpFragment signUpFragment=new SignUpFragment();
        FragmentManager l=getSupportFragmentManager();
        FragmentTransaction ft=l.beginTransaction();

        ft.replace(R.id.fl_login_sign_options,signUpFragment);
        ft.commit();
      b=false;
    }
}
