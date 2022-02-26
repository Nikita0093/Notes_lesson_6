package com.example.notes_lesson_6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class NotesNames extends Fragment {
    public static final String CURRENT_NOTE = "Current_note";
    private Notes currentNote;

    public static NotesNames newInstance() {
        NotesNames fragment = new NotesNames();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_names, container, false);
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
        view.findViewById(R.id.add_note).setOnClickListener(view1 -> new AlertDialog.Builder(requireContext())
                .setTitle("Note creation")
                .setMessage("Do you want to create a new note?")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    Toast.makeText(requireContext(), "New Note's created", Toast.LENGTH_SHORT).show(); //TODO Дописать логику создания заметки
                })
                .setNegativeButton("No", (dialogInterface, i) -> {
                    Toast.makeText(requireContext(), "Cancel", Toast.LENGTH_SHORT).show();

                }).show());
    }


    private void initView(LinearLayout view) {
        String[] noteNames = getResources().getStringArray(R.array.Notes_Names);
        for (int a = 0; a < noteNames.length; a++) {
            String noteName = noteNames[a];
            TextView textView = new TextView(getContext());
            textView.setText(noteName);
            textView.setTextSize(40f);
            textView.setTextColor(getResources().getColor(R.color.white));
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
