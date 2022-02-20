package com.example.notes_lesson_6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Notes_Names extends Fragment {
    public static final String CURRENT_NOTE = "Current_note";
    private Notes currentNote;

    public static Notes_Names newInstance() {
        Notes_Names fragment = new Notes_Names();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes__names, container, false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_NOTE, currentNote);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            currentNote = savedInstanceState.getParcelable(CURRENT_NOTE);
        } else {
            currentNote = new Notes(0);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showLand();

        }
        initView((LinearLayout) view);
    }



    private void initView(LinearLayout view) {
        String[] noteNames = getResources().getStringArray(R.array.Folders);
        for (int a = 0; a < noteNames.length; a++) {
            String noteName = noteNames[a];
            TextView textView = new TextView(getContext());
            textView.setText(noteName);
            textView.setTextSize(40f);
            view.addView(textView);
            final int finalA = a;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentNote = new Notes(finalA);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        showLand();

                    } else {
                        showPortrait();
                    }
                }
            });
        }
    }

    private void showPortrait() {
        NotesDescription notes_Description = NotesDescription.newInstance(currentNote);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Names, notes_Description).addToBackStack(" ").commit();
    }

    private void showLand() {
        NotesDescription notes_Description = NotesDescription.newInstance(currentNote);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Description, notes_Description).commit();
    }
}
