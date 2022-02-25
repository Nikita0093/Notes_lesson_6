package com.example.notes_lesson_6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.descriptoin_child_menu, menu);
        menu.findItem(R.id.action_about).setVisible(false);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_Share): {
                Toast.makeText(requireContext(), "Sharing", Toast.LENGTH_LONG).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_descriptionchild, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        notes = getArguments().getParcelable(Args_Note_Names);
        TextView textView = view.findViewById(R.id.text_description);
        String[] Description = getResources().getStringArray(R.array.Notes_Description);
        textView.setText(Description[notes.getIndex()]);
        popupMenu(textView);
    }

    private void popupMenu(TextView textView) {
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenuChild = new PopupMenu(requireContext(), view);
                requireActivity().getMenuInflater().inflate(R.menu.popup_description_child, popupMenuChild.getMenu());
                popupMenuChild.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case (R.id.action_popup_delete): {
                                Toast.makeText(requireContext(), "This note's deleted", Toast.LENGTH_LONG).show();//TODO дописать логику удаления всей заметки
                                break;

                            }
                            case (R.id.action_popup_clear): {
                                Toast.makeText(requireContext(), "Note Info's cleared", Toast.LENGTH_LONG).show(); //TODO дописать логику отчистки содержимого  заметки
                                break;
                            }

                        }
                        return false;
                    }
                });
                popupMenuChild.show();

                return false;
            }
        });
    }
}
