package com.betelgeuse.dao.app.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.betelgeuse.dao.app.R;
import com.betelgeuse.dao.app.controller.activity.NoteActivityController;
import com.betelgeuse.dao.app.view.holder.ActivityViewHolder;

public class NoteActivity extends AppCompatActivity {

    private NoteActivityController noteActivityController;

    public NoteActivity() {
        noteActivityController = new NoteActivityController(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_create);
        ViewHolder viewHolder = new ViewHolder();
        noteActivityController.onCreate(savedInstanceState, viewHolder);
    }

    public class ViewHolder extends ActivityViewHolder {
        public EditText titleTextView;
        public EditText storyTextView;
        public TextView dateTextView;
        public Button saveNoteButton;

        public ViewHolder() {

            titleTextView = (EditText) findViewById(R.id.title_edit_text);
            storyTextView = (EditText) findViewById(R.id.story_edit_text);
            dateTextView = (TextView) findViewById(R.id.date_text_view);
            saveNoteButton = (Button) findViewById(R.id.save_note_button);
        }
    }
}
