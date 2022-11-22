package com.mszgajewski.notesroom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mszgajewski.notesroom.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {

    EditText editText_title, editText_notes;
    ImageView imageView_save;
    Notes notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        imageView_save = findViewById(R.id.imageView_save);

        imageView_save.setOnClickListener(v -> {
            String title = editText_title.getText().toString();
            String description = editText_notes.getText().toString();

            if (description.isEmpty()){
                Toast.makeText(this, "Proszę wpisać treść notatki", Toast.LENGTH_SHORT).show();
                return;
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE,d MMM yyyy HH:mm a");
            Date date = new Date();

            notes = new Notes();

            notes.setTitle(title);
            notes.setNotes(description);
            notes.setDate(dateFormat.format(date));

            Intent intent = new Intent();
            intent.putExtra("note", notes);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}