package com.teojincheng.walkingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class IndividualWalkActivity extends AppCompatActivity {

    private String TAG = "walkingApp";
    private String INTENT_DATETIMEKEY = "dateTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_walk);
        setTitle("Details of walk");

        Intent intent = getIntent();
        String dateTimeRecv = intent.getExtras().getString(INTENT_DATETIMEKEY);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        Query query = reference.child("user1").orderByChild("time").equalTo(dateTimeRecv);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot walkSnapShot : dataSnapshot.getChildren()) {
                       Log.i(TAG,walkSnapShot.toString());
                    }
                }
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
