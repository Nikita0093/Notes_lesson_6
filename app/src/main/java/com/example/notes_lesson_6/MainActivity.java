package com.example.notes_lesson_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            NotesFolders notes_folders = NotesFolders.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.Names, notes_folders).commit();
        }
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
                finish();
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

