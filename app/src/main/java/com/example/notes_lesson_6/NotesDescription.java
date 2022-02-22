package com.example.notes_lesson_6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NotesDescription extends Fragment {
    public static final String Args_Note_Names = "note_names";
    private Notes notes;

    public static NotesDescription newInstance(Notes notes) {
        NotesDescription fragment = new NotesDescription();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Args_Note_Names, notes);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notes = getArguments().getParcelable(Args_Note_Names);
        getChildFragmentManager().beginTransaction().replace(R.id.container_notes_description_child, NotesDescriptionChild.newInstance(notes)).addToBackStack("").commit();

    }
}
