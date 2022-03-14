package com.example.notes_lesson_6.repository;

import java.util.List;

public interface CardSource {
    int size();

    List<CardData> getAllCardsData();

    CardData getCardData(int position);

}
