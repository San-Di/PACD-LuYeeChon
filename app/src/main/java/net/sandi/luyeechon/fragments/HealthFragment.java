package net.sandi.luyeechon.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import net.sandi.luyeechon.R;
import net.sandi.luyeechon.adapter.HealthAdapter;
import net.sandi.luyeechon.adapter.HealthTopicListAdapter;
import net.sandi.luyeechon.data.models.HealthModel;
import net.sandi.luyeechon.data.vos.HealthVO;
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
    private List<HealthVO> healths;
    private List<HealthVO> healthVOType1;
    private List<HealthVO> healthVOType2;
    private List<HealthVO> healthVOType3;
    private int flag;
    public HealthFragment() {
         healthVOs= HealthModel.getInstance().getHealthVOList();
         healthVOType1 = new ArrayList<HealthVO>();
        healthVOType2 = new ArrayList<HealthVO>();
        healthVOType3= new ArrayList<HealthVO>();
        healths= new ArrayList<HealthVO>();
        for(HealthVO health : healthVOs){
            if (health.getType().equals("1"))
                healthVOType1.add(health);
            else if (health.getType().equals("2"))
                healthVOType2.add(health);
            else if (health.getType().equals("3"))
                healthVOType3.add(health);
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

        final RecyclerView rvHealth = (RecyclerView)view.findViewById(R.id.rv_healths);

        spHealthType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setFlag(position);
                changeTopics(rvHealth);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                healths=healthVOType1;
            }
        });


        return view;
    }

    public static HealthFragment newInstance() {
        return new HealthFragment();
    }

    public int getFlag() {

        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;

    }
    public void changeTopics(RecyclerView rvHealth){
        if (getFlag()==0)
            mHealthAdapter = new HealthAdapter(healthVOType1,controllerHealthItem);
        else if (getFlag()==1)
            mHealthAdapter = new HealthAdapter(healthVOType2,controllerHealthItem);
        else if (getFlag()==2)
            mHealthAdapter = new HealthAdapter(healthVOType3,controllerHealthItem);
        else
            mHealthAdapter = new HealthAdapter(healthVOType1,controllerHealthItem);
        rvHealth.setAdapter(mHealthAdapter);

        int columnSpanCount = getResources().getInteger(R.integer.health_list_grid);
//        rvHealth.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvHealth.setLayoutManager(new GridLayoutManager(getContext(), columnSpanCount));

    }
}
