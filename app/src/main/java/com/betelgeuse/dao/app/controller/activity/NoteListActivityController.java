package com.betelgeuse.dao.app.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.betelgeuse.dao.app.NoteApplication;
import com.betelgeuse.dao.app.R;
import com.betelgeuse.dao.app.controller.adapter.NoteListAdapterController;
import com.betelgeuse.dao.app.model.Note;
import com.betelgeuse.dao.app.model.NoteDao;
import com.betelgeuse.dao.app.view.activity.NoteActivity;
import com.betelgeuse.dao.app.view.activity.NoteListActivity;
import com.betelgeuse.dao.app.view.adapter.RecyclerViewAdapter;
import com.betelgeuse.dao.app.view.widget.RecyclerView;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import static com.betelgeuse.dao.app.view.activity.NoteListActivity.NOTE_CREATE_ACTIVITY_REQUEST_CODE;

/**
 * Created by sajid.shahriar on 5/7/17.
 */

public class NoteListActivityController implements IActivityController<NoteListActivity.ViewHolder>, RecyclerView.OnItemClickListener, View.OnClickListener {

    private NoteListActivity noteListActivity;
    private NoteListActivity.ViewHolder viewHolder;

    private NoteDao noteDao;
    private Query<Note> noteQuery;

    private List<Note> notes;

    private RecyclerViewAdapter recyclerViewAdapter;
    private NoteListAdapterController noteListAdapterController;

    public NoteListActivityController(NoteListActivity noteListActivity) {
        this.noteListActivity = noteListActivity;

    }


    @Override
    public void onCreate(Bundle savedInstanceState, NoteListActivity.ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
        noteListActivity.setSupportActionBar(viewHolder.toolbar);

        this.viewHolder.noteListRecyclerView.setAsListType(RecyclerView.VERTICAL_LAYOUT);

        this.viewHolder.floatingActionButton.setOnClickListener(this);
        this.viewHolder.noteListRecyclerView.setOnItemClickListener(this);

        noteDao = ((NoteApplication) noteListActivity.getApplication()).getDaoSession().getNoteDao();
        noteQuery = noteDao.queryBuilder().orderAsc(NoteDao.Properties.Title).build();
        notes = noteQuery.list();
        noteListAdapterController = new NoteListAdapterController(noteListActivity, notes);
        recyclerViewAdapter = new RecyclerViewAdapter(noteListAdapterController);
        this.viewHolder.noteListRecyclerView.setAdapter(recyclerViewAdapter);
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

    public void saveNoteData(Note note) {
        if (note.getId() == null)
            noteDao.save(note);
        else
            noteDao.update(note);
        updateList();
    }

    private void updateList() {
        notes.clear();
        notes.addAll(noteQuery.list());
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Intent intent = new Intent(noteListActivity, NoteActivity.class);
                noteListActivity.startActivityForResult(intent, NOTE_CREATE_ACTIVITY_REQUEST_CODE);
                break;
        }
    }

    @Override
    public boolean onItemClick(View clickedItemView, int position, long id) {
        Note note = noteListAdapterController.getItem(position);
        Intent intent = new Intent(noteListActivity, NoteActivity.class);
        intent.putExtra("note", note);
        noteListActivity.startActivityForResult(intent, NOTE_CREATE_ACTIVITY_REQUEST_CODE);
        return true;
    }
}
