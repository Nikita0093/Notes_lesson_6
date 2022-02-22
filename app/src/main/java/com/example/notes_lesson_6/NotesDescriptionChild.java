package com.example.notes_lesson_6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NotesDescriptionChild extends Fragment {
    public static final String Args_Note_Names = "note_names";
    private Notes notes;

    public static NotesDescriptionChild newInstance(Notes notes) {
        NotesDescriptionChild fragment = new NotesDescriptionChild();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Args_Note_Names, notes);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_descriptionchild, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notes = getArguments().getParcelable(Args_Note_Names);
        TextView textView = view.findViewById(R.id.text_description);
        String[] Description = getResources().getStringArray(R.array.Notes_Description);
        textView.setText(Description[notes.getIndex()]);
    }
}