package net.sandi.luyeechon.data.models;

import com.google.gson.reflect.TypeToken;

import net.sandi.luyeechon.data.vos.HealthVO;
import net.sandi.luyeechon.utils.CommonInstances;
import net.sandi.luyeechon.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aung on 6/25/16.
 */
public class HealthModel {

    private static final String DUMMY_HEALTH_LIST = "health_list.json";

    private static HealthModel objInstance;

    private List<HealthVO> healthVOList;

    private HealthModel(){
            healthVOList = initializeEventList();
    }

    public static HealthModel getInstance(){
        if(objInstance == null) {
            objInstance = new HealthModel();
        }

        return objInstance;
    }

    private List<HealthVO> initializeEventList() {
        List<HealthVO> eventList = new ArrayList<>();

        try {
            String dummyEventList = JsonUtils.getInstance().loadDummyData(DUMMY_HEALTH_LIST);
            Type listType = new TypeToken<List<HealthVO>>() {
            }.getType();
            eventList = CommonInstances.getGsonInstance().fromJson(dummyEventList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public List<HealthVO> getHealthVOList() {
        return healthVOList;
    }
}
