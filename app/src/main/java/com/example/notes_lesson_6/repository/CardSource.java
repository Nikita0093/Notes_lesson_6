package com.example.notes_lesson_6.repository;

import java.util.List;

public interface CardSource {
    int size();

    List<CardData> getAllCardsData();

    CardData getCardData(int position);

    void clearCardData();

    void addCardData(CardData cardData);

   void deleteCardData(int position);

    void updateCardData(int position, CardData newCardData);

}
