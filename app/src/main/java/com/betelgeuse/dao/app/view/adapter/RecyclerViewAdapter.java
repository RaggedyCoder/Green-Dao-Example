package com.betelgeuse.dao.app.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.betelgeuse.dao.app.controller.adapter.IRecyclerViewAdapterController;


/**
 * Created by sajid.shahriar on 5/7/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private IRecyclerViewAdapterController recyclerViewAdapterController;

    public RecyclerViewAdapter(IRecyclerViewAdapterController recyclerViewAdapterController) {
        this.recyclerViewAdapterController = recyclerViewAdapterController;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return recyclerViewAdapterController.onCreateViewHolder(viewGroup, i);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        recyclerViewAdapterController.onBindViewHolder(viewHolder, position);

    }

    @Override
    public int getItemCount() {
        if (recyclerViewAdapterController != null) {
            return recyclerViewAdapterController.getItemCount();
        } else {
            return 0;
        }
    }


}
