package com.frictionhacks.chatbox.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.frictionhacks.chatbox.Fragment.SignInFragment;
import com.frictionhacks.chatbox.Fragment.SignUpFragment;
import com.frictionhacks.chatbox.R;

public class LoginActivity extends AppCompatActivity {
boolean b=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      change();


    }

    public void change(View view){
        change();
    }
    public void change() {
      if (!b){ SignUpFragment signUpFragment=new SignUpFragment();
        FragmentManager l=getSupportFragmentManager();
        FragmentTransaction ft=l.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.fl_login_sign_options,signUpFragment);
        ft.commit();
      b=true;}
        else{
          SignInFragment signInFragment=new SignInFragment();
          FragmentManager l=getSupportFragmentManager();
          FragmentTransaction ft=l.beginTransaction();
          ft.addToBackStack(null);
          ft.add(R.id.fl_login_sign_options,signInFragment);
          ft.commit();
          b=false;

      }
    }
}
