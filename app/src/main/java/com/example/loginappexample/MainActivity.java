package com.example.loginappexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.loginappexample.Fragments.LoginFragment;
import com.example.loginappexample.Fragments.RegisterFragment;
import com.example.loginappexample.Fragments.WelcomeFragment;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnLoginFormActivityListener {

    private static PrefConfig prefConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefConfig = new PrefConfig(this);

        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null){
                return;
            }
            if(prefConfig.readLoginStatus()){
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new WelcomeFragment()).commit();
            }else{
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new LoginFragment()).commit();
            }
        }
    }

    @Override
    public void performRegister() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new RegisterFragment()).commit();
    }

    @Override
    public void performLogin(String name) {

    }
}
