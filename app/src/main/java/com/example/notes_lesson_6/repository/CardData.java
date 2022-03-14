package com.example.notes_lesson_6.repository;

public class CardData {
    private String noteName;
    private String description;
    private int picture;
    private boolean like;

    public CardData(String noteName, String description, int picture, boolean like) {
        this.noteName = noteName;
        this.description = description;
        this.picture = picture;
        this.like = like;
    }

    public String getNoteName() {
        return noteName;
    }

    public String getDescription() {
        return description;
    }

    public int getPicture() {
        return picture;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
