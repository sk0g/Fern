package com.ymir.fern_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    private Button mMapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mMapButton = findViewById(R.id.activity_profile_maps_button);
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToMaps();
            }
        });
    }

    private void switchToMaps() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
