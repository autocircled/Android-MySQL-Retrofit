package com.example.loginappexample.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.loginappexample.MainActivity;
import com.example.loginappexample.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private TextView textView;
    private Button buttonLogout;
    OnLogoutButtonClickListener logoutButtonClickListener;

    public interface OnLogoutButtonClickListener{
        public void performLogout();
    }


    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        textView = view.findViewById(R.id.textView_welcome_text);
        textView.setText("Welcome " + MainActivity.prefConfig.readName());

        buttonLogout = view.findViewById(R.id.button_logout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutButtonClickListener.performLogout();
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        logoutButtonClickListener = (OnLogoutButtonClickListener) activity;
    }
}
