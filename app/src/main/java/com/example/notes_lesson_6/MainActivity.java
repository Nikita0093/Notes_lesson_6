package com.example.notes_lesson_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            NotesFolders notes_folders = NotesFolders.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.Names, notes_folders).commit();
        }
        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case (R.id.action_about): {
                getSupportFragmentManager().beginTransaction().replace(R.id.Names, new About()).addToBackStack("").commit();
                break;
            }
            case (R.id.action_exit): {
                new AlertDialog.Builder(this)
                        .setTitle("Exiting")
                        .setMessage("Do you want to exit?")
                        .setPositiveButton("Yes", (dialogInterface, i) -> finish())
                        .setNegativeButton("No", (dialogInterface, i) -> {
                            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();

                        }).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.Names);
        if (backStackFragment != null && backStackFragment instanceof NotesDescription) {
            getSupportFragmentManager().popBackStack();
        }
    }
}

