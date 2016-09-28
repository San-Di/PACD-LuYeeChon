package net.sandi.luyeechon.data.models;

import com.google.gson.reflect.TypeToken;

import net.sandi.luyeechon.data.vos.MotivatorVO;
import net.sandi.luyeechon.utils.CommonInstances;
import net.sandi.luyeechon.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaung Htet Lin on 9/24/2016.
 */
public class MotivatorModel {

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
    }

}
