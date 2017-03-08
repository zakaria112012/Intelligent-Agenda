package com.iaproject.miage.intelligentagenda.signinup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.iaproject.miage.intelligentagenda.R;
import com.iaproject.miage.intelligentagenda.dao.DAOAuthetification;
import com.iaproject.miage.intelligentagenda.services.ServicesAuthentification;

public class LoginActivity extends AppCompatActivity {
    ServicesAuthentification sa=new ServicesAuthentification();
    DAOAuthetification daoAuthetification = new DAOAuthetification(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // final ProgressDialog progressDialog = new ProgressDialog(this);
        final Button buttonSignin = (Button) findViewById(R.id.buttonSignin);
        final EditText editTextMail = (EditText) findViewById(R.id.editTextEmail);
        final EditText editTextPasword = (EditText) findViewById(R.id.editTextPassword);
        final TextView textViewSignup = (TextView) findViewById(R.id.textViewSignup);
        final TextView textViewmdpOublie=(TextView) findViewById(R.id.textViewmdp);

        textViewmdpOublie.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ResetPasswordActivity.class));
            }

        });

        buttonSignin.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                String email = editTextMail.getText().toString().trim();
                String password = editTextPasword.getText().toString().trim();
             //  sa.serviceUserLogin();
               daoAuthetification.userLogin(email,password);
            }



          /* private void UserLogin() {



                String email = editTextMail.getText().toString().trim();

                String password = editTextPasword.getText().toString().trim();





                if (TextUtils.isEmpty(email)) {

                    // email vide

                    Toast.makeText(getApplicationContext(), "Veuillez rentrer votre email SVP", Toast.LENGTH_SHORT).show();

                    return;

                }



                if (TextUtils.isEmpty(password)) {



                    //password vide

                    Toast.makeText(getApplicationContext(), "Veuillez rentrer votre mot de passe SVP", Toast.LENGTH_SHORT).show();

                    return;

                }

                progressDialog.setMessage("Please wait ... ");

                progressDialog.show();



                progressDialog.setCancelable(true);



                firebaseAuth.signInWithEmailAndPassword(email, password)

                        .addOnCompleteListener(LoginActivity.this,new OnCompleteListener<AuthResult>() {

                            @Override

                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressDialog.dismiss();

                                if (task.isSuccessful()) {

                                    Toast.makeText(getApplicationContext(), "Bravo", Toast.LENGTH_SHORT).show();

                                    //finish();

                                    startActivity(new Intent(getApplicationContext(),Profile.class));



                                } else {

                                    Toast.makeText(getApplicationContext(), "Connection failed ", Toast.LENGTH_SHORT).show();





                                }

                            }

                        });

            }*/

        });
        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }

        });
    }
}

