package net.sandi.luyeechon.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import net.sandi.luyeechon.LuYeeChonApp;
import net.sandi.luyeechon.R;
import net.sandi.luyeechon.adapter.HealthAdapter;
import net.sandi.luyeechon.adapter.HealthTopicListAdapter;
import net.sandi.luyeechon.data.HealthVO;
import net.sandi.luyeechon.views.holders.HealthViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthFragment extends Fragment {


    private HealthAdapter mHealthAdapter;
    private HealthTopicListAdapter mHealthTopicAdapter;




    private HealthViewHolder.ControllerHealthItem controllerHealthItem;

    private List<HealthVO> healthVOs;
    public HealthFragment() {
         healthVOs=new ArrayList<HealthVO>();
        for(int i=0; i<10; i++) {
            healthVOs.add(new HealthVO(LuYeeChonApp.getContext().getString(R.string.health_title), LuYeeChonApp.getContext().getString(R.string.health_des)));
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] healthTopicsArray = getResources().getStringArray(R.array.health_array);
        List<String> topicList = new ArrayList<>(Arrays.asList(healthTopicsArray));

        mHealthTopicAdapter = new HealthTopicListAdapter(topicList);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        controllerHealthItem = (HealthViewHolder.ControllerHealthItem) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_health, container, false);
        Spinner spHealthType = (Spinner)view.findViewById(R.id.health_dropdown);
        spHealthType.setAdapter(mHealthTopicAdapter);
        mHealthAdapter = new HealthAdapter(healthVOs,controllerHealthItem);
        RecyclerView rvHealth = (RecyclerView)view.findViewById(R.id.rv_healths);
        rvHealth.setAdapter(mHealthAdapter);
        rvHealth.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    public static HealthFragment newInstance() {
        return new HealthFragment();
    }

}
