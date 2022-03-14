package com.example.notes_lesson_6.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.notes_lesson_6.R;
import com.example.notes_lesson_6.repository.LocalRepositoryImpl;


public class NotesNames extends Fragment implements OnItemClickListener {
    public static final String CURRENT_NOTE = "Current_note";
    private Notes currentNote;
    NoteNamesAdapter noteNamesAdapter;


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
        LocalRepositoryImpl localRepository = new LocalRepositoryImpl(requireContext().getResources());
        localRepository.init();
        noteNamesAdapter.setData(localRepository.init());
        noteNamesAdapter.setOnItemClickListener(this);

    }

    private String[] getData() {
        String[] data = getResources().getStringArray(R.array.Notes_Names);
        return data;
    }

    @Override
    public void onItemClick(int position) {
        String [] data = getData();
        Toast.makeText(requireContext(), data[position] + "'re opened", Toast.LENGTH_SHORT).show();
    }
}













        /*if (savedInstanceState != null) {
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

         */