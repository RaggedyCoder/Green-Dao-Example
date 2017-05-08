package com.betelgeuse.dao.app.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.betelgeuse.dao.app.R;

/**
 * Created by sajid.shahriar on 5/7/17.
 */

public class NoteListViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTextView;
    public TextView storyTextView;
    public TextView dateTextView;

    public NoteListViewHolder(View itemView) {
        super(itemView);

        titleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
        storyTextView = (TextView) itemView.findViewById(R.id.story_text_view);
        dateTextView = (TextView) itemView.findViewById(R.id.date_text_view);
    }
}
