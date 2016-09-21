package net.sandi.luyeechon.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.sandi.luyeechon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotivatorFragment extends Fragment {


    public MotivatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motivator, container, false);
        return view;
    }

    public static MotivatorFragment newInstance() {
        return new MotivatorFragment();
    }
}
