package net.sandi.luyeechon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.sandi.luyeechon.R;
import net.sandi.luyeechon.adapter.MotivatorAdapter;
import net.sandi.luyeechon.data.vos.MotivatorVO;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MotivatorFragment extends Fragment {

    private MotivatorAdapter mMotivatorAdapter;
    //   private MotivatorViewHolder.ControllerJokeItem mControllerJoke;

    private List<MotivatorVO> motivatorVOs;

    public MotivatorFragment() {
        motivatorVOs = new ArrayList<MotivatorVO>();
        for (int i = 0; i < 20; i++) {
            motivatorVOs.add(new MotivatorVO("http://www.aungpyaephyo.xyz/phandeeyar_events/dummy_event_pic_2_small.png"));
        }
    }

    public static MotivatorFragment newInstance() {
        return new MotivatorFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motivator, container, false);
        mMotivatorAdapter = new MotivatorAdapter(motivatorVOs);
        RecyclerView rvMotivator = (RecyclerView)view.findViewById(R.id.rv_motivator);
        rvMotivator.setAdapter(mMotivatorAdapter);
        rvMotivator.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));



        return view;
    }
}