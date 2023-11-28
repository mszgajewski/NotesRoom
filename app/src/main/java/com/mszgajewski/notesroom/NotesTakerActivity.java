package com.mszgajewski.notesroom;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.mszgajewski.notesroom.Models.Notes;
import com.mszgajewski.notesroom.databinding.ActivityNotesTakerBinding;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {

    ActivityNotesTakerBinding binding;
    Notes notes;
    boolean isOldNote = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityNotesTakerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notes = new Notes();

        try {
            notes = (Notes) getIntent().getSerializableExtra("old_note");
            binding.editTextTitle.setText(notes.getTitle());
            binding.editTextNotes.setText(notes.getNotes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        binding.imageViewSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = binding.editTextTitle.getText().toString();
                String description = binding.editTextNotes.getText().toString();

                if (description.isEmpty()) {
                    Toast.makeText(NotesTakerActivity.this, "Proszę wpisać treść notatki", Toast.LENGTH_SHORT).show();
                    return;
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE,d MMM yyyy HH:mm a");
                Date date = new Date();
                if (!isOldNote) {
                    notes = new Notes();
                }
                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(dateFormat.format(date));

                Intent intent = new Intent();
                intent.putExtra("note", notes);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}