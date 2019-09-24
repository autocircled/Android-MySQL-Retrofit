package com.example.loginappexample.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginappexample.API.UserModel;
import com.example.loginappexample.MainActivity;
import com.example.loginappexample.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private EditText name, username, userPassword;
    private Button buttonRegister;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        name = view.findViewById(R.id.editText_name);
        username = view.findViewById(R.id.editText_username);
        userPassword = view.findViewById(R.id.editText_password);
        buttonRegister = view.findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
            }
        });
        return view;
    }

    public void performRegistration(){
        String Name = name.getText().toString();
        String UserName = username.getText().toString();
        String UserPass = userPassword.getText().toString();

        Call<UserModel> call = MainActivity.apiInterface.performRegistration(Name,UserName,UserPass);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.body().getResponse().equals("ok")){
                    MainActivity.prefConfig.displayToast("Registration success...");
                }else if(response.body().getResponse().equals("exits")){
                    MainActivity.prefConfig.displayToast("User already exists...");
                }else if(response.body().getResponse().equals("error")) {
                    MainActivity.prefConfig.displayToast("Something went wrong...");
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
        name.setText("");
        username.setText("");
        userPassword.setText("");
    }

}
