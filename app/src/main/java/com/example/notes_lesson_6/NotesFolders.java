package com.example.notes_lesson_6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class NotesFolders extends Fragment {
    public static final String CURRENT_FOLDER = "Current_folder";
    private Notes currentFolder;

    public static NotesFolders newInstance() {
        NotesFolders fragment = new NotesFolders();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_folders, container, false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_FOLDER, currentFolder);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        currentFolder = new Notes(0);

        initView((LinearLayout) view);
    }


    private void initView(LinearLayout view) {
        String[] noteNames = getResources().getStringArray(R.array.Folders);
        for (int b = 0; b < noteNames.length; b++) {
            String noteName = noteNames[b];
            TextView textView = new TextView(getContext());
            textView.setText(noteName);
            textView.setTextSize(40f);
            textView.setTextColor(getResources().getColor(R.color.white));
            view.addView(textView);
            final int finalA = b;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentFolder = new Notes(finalA);
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
        NotesNames notes_names = NotesNames.newInstance();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Names, notes_names).addToBackStack(" ").commit();
    }

    private void showLand() {
        NotesNames notes_names = NotesNames.newInstance();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Names, notes_names).commit();
    }
}
