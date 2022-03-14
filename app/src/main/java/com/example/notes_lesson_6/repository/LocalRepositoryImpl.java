package com.example.notes_lesson_6.repository;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.example.notes_lesson_6.R;

import java.util.ArrayList;
import java.util.List;

public class LocalRepositoryImpl implements CardSource {

    private List<CardData> dataSource;
    private Resources resources;

    public LocalRepositoryImpl(Resources resources) {
        dataSource = new ArrayList<CardData>();
        this.resources = resources;
    }


    public LocalRepositoryImpl init() {
        String[] names = resources.getStringArray(R.array.Notes_Names);
        String[] descriptions = resources.getStringArray(R.array.Notes_Description);
        TypedArray pictures = resources.obtainTypedArray(R.array.Notes_Pictures);
        for (int a = 0; a < names.length; a++) {
            dataSource.add(new CardData(names[a], descriptions[a], pictures.getResourceId(a, 0), false));

        }
        return this;
    }

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public List<CardData> getAllCardsData() {
        return dataSource;
    }

    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }
}
