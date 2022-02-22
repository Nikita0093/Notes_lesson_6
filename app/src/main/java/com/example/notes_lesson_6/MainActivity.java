package com.example.notes_lesson_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            NotesNames notes_names = NotesNames.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.Names, notes_names).commit();
        }
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

