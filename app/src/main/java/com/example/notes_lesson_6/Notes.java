package com.example.notes_lesson_6;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes implements Parcelable {
    private String notesName;
    private String notesDescription;

    protected Notes(Parcel in) {
        notesName = in.readString();
        notesDescription = in.readString();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public Notes(String notesName, String notesDescription) {
        this.notesDescription = notesDescription;
        this.notesName = notesName;
    }

    public String getNotesName() {
        return notesName;
    }

    public void setNotesName(String notesName) {
        this.notesName = notesName;
    }

    public String getNotesDescription() {
        return notesDescription;
    }

    public void setNotesDescription(String notesDescription) {
        this.notesDescription = notesDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(notesName);
        parcel.writeString(notesDescription);
    }
}

