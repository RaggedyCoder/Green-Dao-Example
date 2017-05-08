package com.betelgeuse.dao.app.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.betelgeuse.dao.app.R;
import com.betelgeuse.dao.app.model.Note;
import com.betelgeuse.dao.app.view.activity.NoteActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by sajid.shahriar on 5/7/17.
 */

public class NoteActivityController implements IActivityController<NoteActivity.ViewHolder>, View.OnClickListener {

    private final SimpleDateFormat simpleDateFormat;
    private NoteActivity noteActivity;
    private NoteActivity.ViewHolder viewHolder;
    private Note note;

    public NoteActivityController(NoteActivity noteActivity) {
        this.noteActivity = noteActivity;
        this.simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, NoteActivity.ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
        this.viewHolder.saveNoteButton.setOnClickListener(this);
        note = this.noteActivity.getIntent().getParcelableExtra("note");
        if (note != null) {
            this.viewHolder.titleTextView.setText(note.getTitle());
            this.viewHolder.storyTextView.setText(note.getStory());
            this.viewHolder.titleTextView.setEnabled(false);
            this.viewHolder.storyTextView.setEnabled(false);
            this.viewHolder.dateTextView.setText(this.simpleDateFormat.format(note.getDate()));
        } else {
            this.viewHolder.dateTextView.setText(this.simpleDateFormat.format(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime()));
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_note_button:
                if (TextUtils.isEmpty(viewHolder.titleTextView.getText())) {
                    Toast.makeText(noteActivity, "Please add a title", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(viewHolder.storyTextView.getText())) {
                    Toast.makeText(noteActivity, "Please add a story", Toast.LENGTH_SHORT).show();
                } else {
                    if (note == null)
                        note = new Note();
                    note.setTitle(viewHolder.titleTextView.getText().toString());
                    note.setStory(viewHolder.storyTextView.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtra("note", note);
                    noteActivity.setResult(Activity.RESULT_OK, intent);
                    noteActivity.finish();
                }
                break;
        }
    }
}
