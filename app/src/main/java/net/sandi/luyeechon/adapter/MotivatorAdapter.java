package net.sandi.luyeechon.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.sandi.luyeechon.LuYeeChonApp;
import net.sandi.luyeechon.R;
import net.sandi.luyeechon.views.holders.MotivatorViewHolder;

/**
 * Created by Kaung Htet Lin on 9/20/2016.
 */
public class MotivatorAdapter extends RecyclerView.Adapter<MotivatorViewHolder> {

    private LayoutInflater mInflater;

    public MotivatorAdapter() {
        mInflater = LayoutInflater.from(LuYeeChonApp.getContext());
    }

    @Override
    public MotivatorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_item_motivator, parent, false);
        return new MotivatorViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MotivatorViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}