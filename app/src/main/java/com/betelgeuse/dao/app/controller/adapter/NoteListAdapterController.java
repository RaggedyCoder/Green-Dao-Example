package com.betelgeuse.dao.app.controller.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.betelgeuse.dao.app.view.holder.NoteListViewHolder;
import com.betelgeuse.dao.app.R;
import com.betelgeuse.dao.app.model.Note;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by sajid.shahriar on 5/7/17.
 */

public class NoteListAdapterController implements IRecyclerViewAdapterController<NoteListViewHolder, Note> {

    private final SimpleDateFormat simpleDateFormat;
    private Activity activity;
    private List<Note> noteList;
    private LayoutInflater layoutInflater;

    public NoteListAdapterController(Activity activity, List<Note> noteList) {
        this.activity = activity;
        this.noteList = noteList;
        this.layoutInflater = this.activity.getLayoutInflater();
        this.simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
    }

    @Override
    public NoteListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new NoteListViewHolder(layoutInflater.inflate(R.layout.item_note_list, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(NoteListViewHolder noteListViewHolder, int i) {
        Note note = noteList.get(i);
        noteListViewHolder.titleTextView.setText(note.getTitle());
        noteListViewHolder.storyTextView.setText(note.getStory());
        noteListViewHolder.dateTextView.setText(this.simpleDateFormat.format(note.getDate()));
    }

    @Override
    public int getItemCount() {
        if (noteList != null) {
            return noteList.size();
        } else {
            return 0;
        }
    }

    @Override
    public void updateItemList(List<Note> noteList) {
        this.noteList.clear();
        this.noteList.addAll(noteList);
    }

    @Override
    public void addItem(Note note) {
        this.noteList.add(note);
    }

    @Override
    public Note getItem(int position) {
        return this.noteList.get(position);
    }

    @Override
    public void addAllItem(List<Note> noteList) {
        this.noteList.addAll(noteList);
    }

    @Override
    public void clear() {
        this.noteList.clear();
    }

    @Override
    public void removeItem(Note note) {
        this.noteList.remove(note);
    }

    @Override
    public void removeAt(int position) {
        this.noteList.remove(position);
    }
}
