package net.sandi.luyeechon.fragments;

<<<<<<< HEAD
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
=======
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< HEAD
import net.sandi.luyeechon.R;
import net.sandi.luyeechon.adapter.MotivatorAdapter;
import net.sandi.luyeechon.data.models.MotivatorModel;
import net.sandi.luyeechon.data.vos.MotivatorVO;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MotivatorFragment extends Fragment {

    private MotivatorAdapter mMotivatorAdapter;
    //   private MotivatorViewHolder.ControllerJokeItem mControllerJoke;

    private List<MotivatorVO> motivatorVOs;

    public MotivatorFragment() {
        motivatorVOs= MotivatorModel.getInstance().getMotivatorList();
       /* motivatorVOs = new ArrayList<MotivatorVO>();
        for (int i = 0; i < 20; i++) {
            motivatorVOs.add(new MotivatorVO("http://www.aungpyaephyo.xyz/phandeeyar_events/dummy_event_pic_2_small.png"));
        }*/
    }

    public static MotivatorFragment newInstance() {
        return new MotivatorFragment();
    }
=======
import net.sandi.luyeechon.LuYeeChonApp;
import net.sandi.luyeechon.R;
import net.sandi.luyeechon.adapters.MotivatorAdapter;
import net.sandi.luyeechon.data.models.MotivatorModel;
import net.sandi.luyeechon.data.persistence.LuYeeChonContract;
import net.sandi.luyeechon.data.vos.MotivatorVO;
import net.sandi.luyeechon.events.DataEvent;
import net.sandi.luyeechon.utils.LuYeeChonConstants;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * A placeholder fragment containing a simple view.
 */
public class MotivatorFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private MotivatorAdapter mMotivatorAdapter;

    private List<MotivatorVO> motivatorVOs;

//    public MotivatorFragment() {
//        //      motivatorVOs= MotivatorModel.getInstance().getMotivatorList();
//        motivatorVOs = MotivatorModel.getInstance().getMotivatorList();
//
//    }

    public static MotivatorFragment newInstance() {
        MotivatorFragment fragment = new MotivatorFragment();
        return fragment;
     }
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motivator, container, false);
<<<<<<< HEAD
        mMotivatorAdapter = new MotivatorAdapter(motivatorVOs);
=======

        List<MotivatorVO> motivatorList=MotivatorModel.getInstance().getMotivatorList();
        mMotivatorAdapter = new MotivatorAdapter(motivatorList);
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        RecyclerView rvMotivator = (RecyclerView) view.findViewById(R.id.rv_motivator);
        rvMotivator.setAdapter(mMotivatorAdapter);

        rvMotivator.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return view;
    }
<<<<<<< HEAD
=======

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getSupportLoaderManager().initLoader(LuYeeChonConstants.ATTRACTION_LIST_LOADER, null, this);

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        EventBus eventBus = EventBus.getDefault();
        eventBus.unregister(this);
    }

    public void onEventMainThread(DataEvent.MotivatorDataLoadedEvent event) {
        String extra = event.getExtraMessage();
        //     Toast.makeText(getApplicationContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

    //    List<AttractionVO> newAttractionList = AttractionModel.getInstance().getAttractionList();
        List<MotivatorVO> newAttractionList = event.getAttractionList();
        mMotivatorAdapter.setNewData(newAttractionList);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                LuYeeChonContract.MotivatorEntry.CONTENT_URI,
                null,
                null,
                null,
                LuYeeChonContract.MotivatorEntry._ID );
        //  return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        List<MotivatorVO> motivatorList = new ArrayList<>();
        if (data != null && data.moveToFirst()) {
            do {
                MotivatorVO motivator = MotivatorVO.parseFromCursor(data);
                //  motivator.setImage(Mo.loadAttractionImagesByTitle(motivator.getTitle()));
                motivatorList.add(motivator);
            } while (data.moveToNext());
        }

           Log.d(LuYeeChonApp.TAG, "Retrieved attractions DESC : " + motivatorList.size());
        mMotivatorAdapter.setNewData(motivatorList);

        MotivatorModel.getInstance().setStoredData(motivatorList);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

//    public void onEventMainThread(DataEvent.MotivatorDataLoadedEvent event) {
//        String extra = event.getExtraMessage();
//        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();
//
//        //List<AttractionVO> newAttractionList = AttractionModel.getInstance().getAttractionList();
//        List<MotivatorVO> newAttractionList = event.getAttractionList();
//        mMotivatorAdapter.setNewData(newAttractionList);
//    }
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
}
