package com.example.notes_lesson_6.repository;

public class CardData {
    private String Folder_name;
    private String Note_name;
    private int picture;
    private int like;

    public CardData(String folder_name, String note_name, int picture, int like) {
        Folder_name = folder_name;
        Note_name = note_name;
        this.picture = picture;
        this.like = like;
    }

    public String getFolder_name() {
        return Folder_name;
    }

    public String getNote_name() {
        return Note_name;
    }

    public int getPicture() {
        return picture;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;

    }

}