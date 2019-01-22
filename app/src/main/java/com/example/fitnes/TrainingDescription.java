package com.example.fitnes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TrainingDescription extends AppCompatActivity {

    private TextView description;
    private Toolbar toolbar;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_description);
        view = findViewById(R.id.coordinator_training_description);
        toolbar = findViewById(R.id.toolbar_training_description);
        setSupportActionBar(toolbar);

        Log.d("MYLOG", "TrainingDescription");
        description = findViewById(R.id.description_training);
        Intent intent = getIntent();
        description.setText(intent.getStringExtra("TrainingName"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_training) {
            Snackbar.make(view, "You have added training", Snackbar.LENGTH_LONG).show();
        }
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.training_description_menu, menu);
        return true;
    }


}