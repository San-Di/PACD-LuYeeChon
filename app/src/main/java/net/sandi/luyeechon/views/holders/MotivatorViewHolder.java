package net.sandi.luyeechon.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import net.sandi.luyeechon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 9/20/2016.
 */
public class MotivatorViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_motivator)
    ImageView IvMotivator;

    public MotivatorViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}