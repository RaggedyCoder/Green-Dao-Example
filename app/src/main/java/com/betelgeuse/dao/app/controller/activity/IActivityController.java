package com.betelgeuse.dao.app.controller.activity;

import android.os.Bundle;

import com.betelgeuse.dao.app.view.holder.ActivityViewHolder;

/**
 * Created by sajid.shahriar on 5/7/17.
 */

public interface IActivityController<T extends ActivityViewHolder> {

    void onCreate(Bundle savedInstanceState, T viewHolder);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onRestart();

    void onDestroy();
}
