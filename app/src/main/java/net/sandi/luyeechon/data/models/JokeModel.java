package net.sandi.luyeechon.data.models;

import com.google.gson.reflect.TypeToken;

import net.sandi.luyeechon.data.vos.JokeVO;
import net.sandi.luyeechon.utils.CommonInstances;
import net.sandi.luyeechon.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UNiQUE on 9/23/2016.
 */
public class JokeModel {
    private static final String DUMMY_JOKE_LIST = "joke_list.json";

    private static JokeModel objInstance;

    private List<JokeVO> jokeVOList;

    private JokeModel(){
        jokeVOList = initializeJokeList();
    }

    public static JokeModel getInstance(){
        if(objInstance == null) {
            objInstance = new JokeModel();
        }

        return objInstance;
    }

    private List<JokeVO> initializeJokeList() {
        List<JokeVO> jokeList = new ArrayList<>();

        try {
            String dummyJokeList = JsonUtils.getInstance().loadDummyData(DUMMY_JOKE_LIST);
            Type listType = new TypeToken<List<JokeVO>>() {
            }.getType();
            jokeList = CommonInstances.getGsonInstance().fromJson(dummyJokeList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jokeList;
    }

    public List<JokeVO> getJokeVOList() {
        return jokeVOList;
    }
}
