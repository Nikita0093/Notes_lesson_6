package com.example.notes_lesson_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Notes_Names notes_names = Notes_Names.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.Names, notes_names).commit();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Notes defaultName = new Notes("Note One","Info Note One");
                NotesDescription notes_Description = NotesDescription.newInstance(defaultName);
                getSupportFragmentManager().beginTransaction().replace(R.id.Description, notes_Description).commit();

            }
        }
    }
}
