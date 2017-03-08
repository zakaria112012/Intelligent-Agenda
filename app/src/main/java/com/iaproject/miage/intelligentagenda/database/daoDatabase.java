package com.iaproject.miage.intelligentagenda.database;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.iaproject.miage.intelligentagenda.feature.event.model.Agenda;
import com.iaproject.miage.intelligentagenda.feature.event.model.Event;

/**
 * Created by kp on 07/03/2017.
 */

public class daoDatabase {




    final FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    final DatabaseReference databaseReference = database.getReference();



    public final void addEvent(Event event,Agenda agenda){


        FirebaseUser user=firebaseAuth.getCurrentUser();
        databaseReference.child("users").child(user.getEmail()).child(agenda.titleAgenda).setValue(event);
        agenda.addEvent(event);




    }

   /* final void addElementListView(SimpleAdapter sa ,List<HashMap<String, Object>> list,HashMap<String, Object> map,ListView lv,String title,int i){


        map = new HashMap<String, Object>();
        map.put("titre", title);

        i++;
        list.add(map);
        sa.notifyDataSetChanged();
        lv.setAdapter(sa);

    }
    */


}
