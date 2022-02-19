package com.example.notes_lesson_6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Notes_Names extends Fragment {
    public static Notes_Names newInstance() {
        Notes_Names fragment = new Notes_Names();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes__names, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] noteNames = getResources().getStringArray(R.array.Notes_Names);
        for (int a = 0; a < noteNames.length; a++) {
            String noteName = noteNames[a];
            TextView textView = new TextView(getContext());
            textView.setText(noteName);
            textView.setTextSize(30f);
            ((LinearLayout) view).addView(textView);
            final int finalA = a;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Notes Name = new Notes(finalA);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        NotesDescription notes_Description = NotesDescription.newInstance(Name);

                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.text_description,notes_Description).commit();

                    }else {
                        NotesDescription notes_Description = NotesDescription.newInstance(Name);

                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Names,notes_Description).addToBackStack(" ").commit();



                    }
                }
            });

        }
    }
}
