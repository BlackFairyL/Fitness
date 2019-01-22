package com.example.fitnes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import APIParse.Exercise;

public class ExerciseChoosing extends AppCompatActivity implements ExerciseAdapter.ListItemClickListener{

    private List<Exercise> exerciseList;
    private RecyclerView list;
    private View viewExercise;
    private Toolbar toolbarExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_choose);
        viewExercise = findViewById(R.id.coordinator_exercise);
        toolbarExercise = findViewById(R.id.toolbar_exercise);
        setSupportActionBar(toolbarExercise);

        list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        exerciseList = MainActivity.getExercise();
        ExerciseAdapter adapter = new ExerciseAdapter(exerciseList, this);
        list.setAdapter(adapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Exercise exercise = exerciseList.get(clickedItemIndex);
        Intent intent = new Intent(getApplicationContext(), ExerciseDescription.class);
        intent.putExtra("Id", Integer.toString(exercise.getId())); //Открытие активности с exercise decription
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save_training) {
            Snackbar.make(viewExercise, "You have saved training", Snackbar.LENGTH_LONG).show();
        }
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.choose_exercise_menu, menu);
        return true;
    }
}
