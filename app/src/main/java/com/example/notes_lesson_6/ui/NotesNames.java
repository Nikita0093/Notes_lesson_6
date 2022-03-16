package com.example.notes_lesson_6.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.notes_lesson_6.R;
import com.example.notes_lesson_6.repository.CardData;
import com.example.notes_lesson_6.repository.CardSource;
import com.example.notes_lesson_6.repository.LocalRepositoryImpl;


public class NotesNames extends Fragment implements OnItemClickListener {
    public static final String CURRENT_NOTE = "Current_note";
    private Notes currentNote;
    NoteNamesAdapter noteNamesAdapter;
    CardSource cardSource;


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
        String[] data = getData();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        noteNamesAdapter = new NoteNamesAdapter();
        recyclerView.setAdapter(noteNamesAdapter);
        cardSource = new LocalRepositoryImpl(requireContext().getResources()).init();
        noteNamesAdapter.setData(cardSource);
        noteNamesAdapter.setOnItemClickListener(this);

        setHasOptionsMenu(true);


        view.findViewById(R.id.add_note).setOnClickListener(view1 -> new AlertDialog.Builder(requireContext())
                .setTitle("Note creation")
                .setMessage("Do you want to create a new note?")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    Toast.makeText(requireContext(), "New Note's created", Toast.LENGTH_SHORT).show();

                    cardSource.addCardData(new CardData("New Note" + cardSource.size(), "New Note Description", 0, false));
                    noteNamesAdapter.notifyItemInserted(cardSource.size() - 1);
                })
                .setNegativeButton("No", (dialogInterface, i) -> {
                    Toast.makeText(requireContext(), "Cancel", Toast.LENGTH_SHORT).show();

                }).show());


    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.notes_name_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {

            case (R.id.action_menuNoteName_clear): {
                cardSource.clearCardData();
                noteNamesAdapter.notifyDataSetChanged();
                break;


            }

            case (R.id.action_menuNoteNameAdd): {
                cardSource.addCardData(new CardData("New Note" + cardSource.size(), "New Note Description", 0, false));
                noteNamesAdapter.notifyItemInserted(cardSource.size() - 1);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }


    private String[] getData() {
        String[] data = getResources().getStringArray(R.array.Notes_Names);
        return data;
    }

    @Override
    public void onItemClick(int position) {
        String[] data = getData();
        Toast.makeText(requireContext(), data[position] + "'re opened", Toast.LENGTH_SHORT).show();
    }
}

