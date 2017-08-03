package com.teojincheng.walkingapp;

/**
 * Created by Jin Cheng
 *
 * Retrieve all the walks that are stored in the database and display
 * a listview which on click, will start another activity based on the walk selected.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ListOfWalks extends AppCompatActivity {

    ListView listview;
    ArrayList<String> list = new ArrayList<>();
    private String TAG = "walkingApp";
    Intent intent;
    private String INTENT_DATETIMEKEY = "dateTime";
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_walks);
        setTitle(R.string.listOfWalks);

        //create the view elements
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listview = (ListView) findViewById(R.id.listview);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
        listview.setAdapter(adapter);
        intent = new Intent(this, IndividualWalkActivity.class);

        //before the retrieve of data from database, show the circular progress bar.
        progressBar.setVisibility(View.VISIBLE);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference rt = database.getReference("user1");


        rt.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //  retrieve the dateTime of all the walks in the database and display them on the listview
                // once data has been fetch, the progress bar is removed.
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String dateTime = (String) postSnapshot.child("time").getValue();
                    list.add(dateTime);
                    Collections.reverse(list);
                    progressBar.setVisibility(View.GONE);
                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // when an item of the list is selected, pass info of the selected walk to the next activity.

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String clickedValue =(String) parent.getItemAtPosition(position);
                intent.putExtra(INTENT_DATETIMEKEY, clickedValue);
                startActivity(intent);

            }
        });
    }
}
