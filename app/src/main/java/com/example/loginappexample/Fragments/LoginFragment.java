package com.example.loginappexample.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loginappexample.API.UserModel;
import com.example.loginappexample.MainActivity;
import com.example.loginappexample.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private TextView textViewReg;
    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private OnLoginFormActivityListener onLoginFormActivityListener;

    public interface OnLoginFormActivityListener{
        public void performRegister();
        public void performLogin(String name);
    }


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        textViewReg = view.findViewById(R.id.textView_login);
        textViewReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginFormActivityListener.performRegister();
            }
        });

        editTextUsername = view.findViewById(R.id.user_name);
        editTextPassword = view.findViewById(R.id.user_password);
        buttonLogin = view.findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLoginForm();
            }
        });
        return view;
    }

    private void performLoginForm() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        Call<UserModel> userModelCall = MainActivity.apiInterface.performUserLogin(username, password);
        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.d(TAG, "onResponse: " + response.raw());
//                if(response.body().getReply().equals("success")){
//                    MainActivity.prefConfig.writeLoginStatus(true);
//                    onLoginFormActivityListener.performLogin(response.body().getName());
//                }else if(response.body().getReply().equals("failed")){
//                    MainActivity.prefConfig.displayToast("Login failed..Try again later...");
//                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
        editTextUsername.setText("");
        editTextPassword.setText("");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        onLoginFormActivityListener = (OnLoginFormActivityListener) activity;
    }
}
