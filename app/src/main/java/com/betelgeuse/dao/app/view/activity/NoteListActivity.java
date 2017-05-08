package com.betelgeuse.dao.app.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.betelgeuse.dao.app.R;
import com.betelgeuse.dao.app.controller.activity.NoteListActivityController;
import com.betelgeuse.dao.app.model.Note;
import com.betelgeuse.dao.app.view.holder.ActivityViewHolder;
import com.betelgeuse.dao.app.view.widget.RecyclerView;

public class NoteListActivity extends AppCompatActivity {

    public static final int NOTE_CREATE_ACTIVITY_REQUEST_CODE = 1001;

    private NoteListActivityController noteListActivityController;

    public NoteListActivity() {
        this.noteListActivityController = new NoteListActivityController(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewHolder viewHolder = new ViewHolder();
        noteListActivityController.onCreate(savedInstanceState, viewHolder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                switch (requestCode) {
                    case NOTE_CREATE_ACTIVITY_REQUEST_CODE:
                        Note note = data.getParcelableExtra("note");
                        noteListActivityController.saveNoteData(note);
                        break;
                }
                break;
        }
    }

    public class ViewHolder extends ActivityViewHolder {
        public RecyclerView noteListRecyclerView;
        public FloatingActionButton floatingActionButton;
        public Toolbar toolbar;


        public ViewHolder() {
            toolbar = (Toolbar) findViewById(R.id.toolbar);

            noteListRecyclerView = (RecyclerView) findViewById(R.id.note_list_recycler_view);
            floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        }
    }
}
