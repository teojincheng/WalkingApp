package com.teojincheng.walkingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    private String INTENT_DISTANCEKEY = "distance";
    private String INTENT_TIMEKEY = "time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        setTitle(R.string.runCompleted);

        Intent intent = getIntent();
        double completedDist = intent.getExtras().getDouble(INTENT_DISTANCEKEY);
        long completedTime = intent.getExtras().getLong(INTENT_TIMEKEY);


        TextView textViewDurationF = (TextView) findViewById(R.id.textViewTimeF);
        TextView textViewDistanceF = (TextView) findViewById(R.id.textViewDistF);

        Button buttonBack = (Button) findViewById(R.id.buttonBack);

        textViewDistanceF.setText(formatDistance(completedDist));
        textViewDurationF.setText(formatDuration(completedTime));


        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentToMap = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intentToMap);

            }
        });


    }


    public String formatDistance(double pDistance) {
        if (pDistance / 1000 >= 1) {
            String distanceStr = String.format("%.2f", (pDistance / 1000));
            return distanceStr + "km";
        } else {
            String distanceStr = String.format("%.0f", pDistance);
            return distanceStr + "m";
        }
    }

    public String formatDuration(long pDuration) {
        return DateUtils.formatElapsedTime(pDuration);

    }
}
