package com.ymir.fern_app;

import java.net.MalformedURLException;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.sql.*;
import java.util.concurrent.ExecutionException;

import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceJsonTable;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

public class ProfileActivity extends AppCompatActivity {

    private Button mMapButton;
    private MobileServiceClient mClient;

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

        try {
            mClient = new MobileServiceClient(
                    "https://fernapp.azurewebsites.net",
                    this
            );

            MobileServiceTable<Person> mPersonTable = mClient.getTable(Person.class);
            List<Person> result = mPersonTable.execute().get();

        }
        catch (MalformedURLException | MobileServiceException | ExecutionException | InterruptedException e) {
            Log.w("TAGTAGTAG", "asdfadsadsa");
            e.printStackTrace();
        }
    }

    private void switchToMaps() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }


}
