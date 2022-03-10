package com.example.notes_lesson_6.repository;

public interface DataSource {
    int size();
    CardData[] getAllCardsView();
    CardData getCardData(int position);


}
