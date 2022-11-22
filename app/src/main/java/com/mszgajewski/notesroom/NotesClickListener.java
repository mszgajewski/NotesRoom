package com.mszgajewski.notesroom;

import androidx.cardview.widget.CardView;

import com.mszgajewski.notesroom.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
