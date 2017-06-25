package com.teojincheng.walkingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "walkingApp";
    GenericTypeIndicator<ArrayList<Integer>> t;
    ArrayList<Integer> rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     t = new GenericTypeIndicator<ArrayList<Integer>>() {};
  rl = new ArrayList<Integer>();

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(33);
        al.add(67);
        al.add(5);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
       // DatabaseReference myRef = database.getReference("message");
        DatabaseReference rt = database.getReference("rt");
       // rt.setValue("one");

        DatabaseReference child = rt.push();
        child.setValue("oneobe");

        DatabaseReference aChild = rt.push();
        aChild.setValue("tweowto");
      //  myRef.setValue(al);

      // myRef.setValue("wow");

        // Read from the database
        /*
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


               rl= dataSnapshot.getValue(t);
                Log.i(TAG,"gere");

                for (Integer temp : rl){
                    Log.i(TAG,String.valueOf(temp));
                }



            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });
*/
    }
}
