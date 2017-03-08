package com.iaproject.miage.intelligentagenda.SignInUp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.iaproject.miage.intelligentagenda.R;

/**
 * Created by kp on 08/03/2017.
 */

public class Dao {

    public Activity MyActivity ;


    LoginActivity lg= new LoginActivity();


    public Dao(Activity myActivity) {
        MyActivity = myActivity;
    }

    public FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    final Button buttonSignin = (Button)this.MyActivity.findViewById(R.id.buttonSignin);
    final EditText editTextMail = (EditText)this.MyActivity.findViewById(R.id.editTextEmail);
    final ProgressDialog progressDialog = new ProgressDialog(MyActivity);

    final EditText editTextPasword = (EditText)this.MyActivity.findViewById(R.id.editTextPassword);





    public void UserLogin(String email,String password) {

        //String email = editTextMail.getText().toString().trim();
        //String password = editTextPasword.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            // email vide
            Toast.makeText(MyActivity.getApplicationContext(), "Veuillez rentrer votre email SVP", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {

            //password vide
            Toast.makeText(MyActivity.getApplicationContext(), "Veuillez rentrer votre mot de passe SVP", Toast.LENGTH_SHORT).show();
            return;
        }
      /*  progressDialog.setMessage("Please wait ... ");
        progressDialog.show();

        progressDialog.setCancelable(true);*/

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(MyActivity,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(MyActivity.getApplicationContext(), "Bravo", Toast.LENGTH_SHORT).show();
                            //finish();
                            // MyActivity.startActivity(new Intent(MyActivity.getApplicationContext(),Profile.class));


                        } else {
                            Toast.makeText(MyActivity.getApplicationContext(), "Connection failed ", Toast.LENGTH_SHORT).show();


                        }
                    }
                });
    }


}
