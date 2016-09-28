package net.sandi.luyeechon.data.models;

<<<<<<< HEAD
import com.google.gson.reflect.TypeToken;

import net.sandi.luyeechon.data.vos.MotivatorVO;
import net.sandi.luyeechon.utils.CommonInstances;
import net.sandi.luyeechon.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

=======
import net.sandi.luyeechon.data.agents.LuYeeChonDataAgent;
import net.sandi.luyeechon.data.agents.OfflineDataAgent;
import net.sandi.luyeechon.data.agents.retrofit.RetrofitDataAgent;
import net.sandi.luyeechon.data.vos.MotivatorVO;
import net.sandi.luyeechon.events.DataEvent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
/**
 * Created by Kaung Htet Lin on 9/24/2016.
 */
public class MotivatorModel {

<<<<<<< HEAD
    private static final String DUMMY_MOTIVATOR_LIST = "motivator_list.json";

    private static MotivatorModel objInstance;

    private List<MotivatorVO> motivatorList;

    private MotivatorModel(){
        motivatorList = initializeQuizList();
    }

    public static MotivatorModel getInstance(){
        if(objInstance == null) {
            objInstance = new MotivatorModel();
        }

        return objInstance;
    }

    private List<MotivatorVO> initializeQuizList() {
        List<MotivatorVO> MotivatorList = new ArrayList<>();

        try {
            String dummyMotivatorList = JsonUtils.getInstance().loadDummyData(DUMMY_MOTIVATOR_LIST);
            Type listType = new TypeToken<List<MotivatorVO>>() {
            }.getType();
            MotivatorList = CommonInstances.getGsonInstance().fromJson(dummyMotivatorList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return MotivatorList;
    }

    public List<MotivatorVO> getMotivatorList() {
        return motivatorList;
=======
    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    private static final int INIT_DATA_AGENT_OFFLINE = 1;
    private static final int INIT_DATA_AGENT_HTTP_URL_CONNECTION = 2;
    private static final int INIT_DATA_AGENT_OK_HTTP = 3;
    private static final int INIT_DATA_AGENT_RETROFIT = 4;

    private static MotivatorModel objInstance;

    private List<MotivatorVO> mMotivatorList;

    private LuYeeChonDataAgent dataAgent;

    private MotivatorModel() {
        mMotivatorList = new ArrayList<>();
        initDataAgent(INIT_DATA_AGENT_RETROFIT);
        dataAgent.loadMotivator();
    }

    public static MotivatorModel getInstance() {
        if (objInstance == null) {
            objInstance = new MotivatorModel();
        }
        return objInstance;
    }

    private void initDataAgent(int initType) {
        switch (initType) {
            case INIT_DATA_AGENT_OFFLINE:
                dataAgent = OfflineDataAgent.getInstance();
                break;
            case INIT_DATA_AGENT_HTTP_URL_CONNECTION:
              //  dataAgent = HttpUrlConnectionDataAgent.getInstance();
                break;
            case INIT_DATA_AGENT_OK_HTTP:
             //   dataAgent = OkHttpDataAgent.getInstance();
                break;
            case INIT_DATA_AGENT_RETROFIT:
                dataAgent = RetrofitDataAgent.getInstance();
                break;
        }
    }

    public List<MotivatorVO> getMotivatorList() {
        return mMotivatorList;
    }

//    public MotivatorVO getAttractionByName(String attractionName) {
//        for (MotivatorVO attraction : mMotivatorList) {
//            if (attraction.getTitle().equals(attractionName))
//                return attraction;
//        }
//
//        return null;
//    }

    public void notifyMotivatorLoaded(List<MotivatorVO> motivatorList) {
        //Notify that the data is ready - using LocalBroadcast
        mMotivatorList = motivatorList;

        //keep the data in persistent layer.
        MotivatorVO.saveMotivator(mMotivatorList);

        broadcastMotivatorLoadedWithEventBus();
        //broadcastMotivatorLoadedWithLocalBroadcastManager();
    }

    public void notifyErrorInLoadingMotivator(String message) {

    }

//    private void broadcastMotivatorLoadedWithLocalBroadcastManager() {
//        Intent intent = new Intent(BROADCAST_DATA_LOADED);
//        intent.putExtra("key-for-extra", "extra-in-broadcast");
//        LocalBroadcastManager.getInstance(LuYeeChonApp.getContext()).sendBroadcast(intent);
//    }

    private void broadcastMotivatorLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.MotivatorDataLoadedEvent("extra-in-broadcast", mMotivatorList));
    }

    public void setStoredData(List<MotivatorVO> motivatorList) {
        mMotivatorList = motivatorList;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
    }

}
