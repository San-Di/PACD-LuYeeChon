package net.sandi.luyeechon.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.sandi.luyeechon.LuYeeChonApp;
import net.sandi.luyeechon.R;
import net.sandi.luyeechon.adapter.JokeAdapter;
import net.sandi.luyeechon.data.JokeVO;
import net.sandi.luyeechon.views.holders.JokeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeFragment extends Fragment {


    private JokeAdapter mJokeAdpater;
    private JokeViewHolder.ControllerJokeItem mControllerJoke;

    private List<JokeVO> jokeVOs;
    public JokeFragment() {
        jokeVOs=new ArrayList<JokeVO>();
        for(int i=0; i<10; i++) {
            jokeVOs.add(new JokeVO(LuYeeChonApp.getContext().getString(R.string.joke_title), LuYeeChonApp.getContext().getString(R.string.joke_des)));
            jokeVOs.add(new JokeVO(LuYeeChonApp.getContext().getString(R.string.joke_title2),LuYeeChonApp.getContext().getString(R.string.joke_des2)));
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerJoke = (JokeViewHolder.ControllerJokeItem) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        mJokeAdpater = new JokeAdapter(jokeVOs,mControllerJoke);
        RecyclerView rvJoke = (RecyclerView)view.findViewById(R.id.rv_jokes);
        rvJoke.setAdapter(mJokeAdpater);
        rvJoke.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    public static JokeFragment newInstance() {
        return new JokeFragment();
    }
}