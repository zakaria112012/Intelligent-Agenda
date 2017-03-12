package com.iaproject.miage.intelligentagenda.database;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.iaproject.miage.intelligentagenda.feature.event.model.Event;

/**
 * Created by kp on 07/03/2017.
 */

public class daoDatabase {

    final FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    final DatabaseReference databaseReference = database.getReference();


    public final void addEvent(Event event){


        FirebaseUser user=firebaseAuth.getCurrentUser();
       databaseReference.child("users").child(user.getEmail()).setValue(event);
      //  databaseReference.child("users").setValue(event);
        //agenda.addEvent(event);




    }


}
