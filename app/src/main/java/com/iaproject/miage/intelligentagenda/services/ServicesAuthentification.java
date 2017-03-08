package com.iaproject.miage.intelligentagenda.services;

import android.widget.EditText;

import com.iaproject.miage.intelligentagenda.R;
import com.iaproject.miage.intelligentagenda.SignInUp.LoginActivity;
import com.iaproject.miage.intelligentagenda.dao.DAOAuthetification;

/**
 * Created by kp on 08/03/2017.
 */





public class ServicesAuthentification {


    public void serviceUserLogin(){

        LoginActivity loginActivity = new LoginActivity();

        final EditText editTextMail = (EditText) loginActivity.findViewById(R.id.editTextEmail);
        final EditText editTextPasword = (EditText) loginActivity.findViewById(R.id.editTextPassword);

        String email = editTextMail.getText().toString().trim();
        String password = editTextPasword.getText().toString().trim();

        DAOAuthetification daoAuthetification = new DAOAuthetification(loginActivity);
        daoAuthetification.userLogin(email,password);

    }

    public void serviceResetPassword(String mail){
        LoginActivity loginActivity = new LoginActivity();
        DAOAuthetification daoAuthetification = new DAOAuthetification(loginActivity);
        daoAuthetification.resetPassword(mail);

    }

    public void serviceRegisterUser(String mail , String pass){
        LoginActivity loginActivity = new LoginActivity();
        DAOAuthetification daoAuthetification = new DAOAuthetification(loginActivity);
        daoAuthetification.registerUser(mail,pass);

    }


}
