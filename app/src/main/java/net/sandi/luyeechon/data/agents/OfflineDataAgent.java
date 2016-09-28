package net.sandi.luyeechon.data.agents;

import com.google.gson.reflect.TypeToken;

<<<<<<< HEAD
import net.sandi.luyeechon.data.models.HealthModel;
import net.sandi.luyeechon.data.models.JokeModel;
import net.sandi.luyeechon.data.vos.HealthVO;
import net.sandi.luyeechon.data.vos.JokeVO;
=======
import net.sandi.luyeechon.data.models.MotivatorModel;
import net.sandi.luyeechon.data.vos.MotivatorVO;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
import net.sandi.luyeechon.utils.CommonInstances;
import net.sandi.luyeechon.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

<<<<<<< HEAD
public class OfflineDataAgent implements DataAgent {

    private static final String OFFLINE_HEALTH_LIST = "health_list.json";
    private static final String OFFLINE_JOKE_LIST = "joke_list.json";
=======
/**
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class OfflineDataAgent implements LuYeeChonDataAgent {

    private static final String OFFLINE_MOTIVATOR_LIST = "motivator_list.json";
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54

    private static OfflineDataAgent objInstance;

    private OfflineDataAgent() {

    }

    public static OfflineDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new OfflineDataAgent();
        }

        return objInstance;
    }

<<<<<<< HEAD
    @Override
    public void loadHealthList() {
        try {
            String healths = JsonUtils.getInstance().loadDummyData(OFFLINE_HEALTH_LIST);
            Type listType = new TypeToken<List<HealthVO>>() {
            }.getType();
            List<HealthVO> healthList = CommonInstances.getGsonInstance().fromJson(healths, listType);

            HealthModel.getInstance().notifyHealthListLoaded(healthList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadJokeList() {
        try {
            String jokes = JsonUtils.getInstance().loadDummyData(OFFLINE_JOKE_LIST);
            Type listType = new TypeToken<List<JokeVO>>() {
            }.getType();
            List<JokeVO> jokeList = CommonInstances.getGsonInstance().fromJson(jokes, listType);

            JokeModel.getInstance().notifyJokeListLoaded(jokeList);
=======

    @Override
    public void loadMotivator() {
        try {
            String motivator = JsonUtils.getInstance().loadDummyData(OFFLINE_MOTIVATOR_LIST);
            Type listType = new TypeToken<List<MotivatorVO>>() {
            }.getType();
            List<MotivatorVO> motivatorList = CommonInstances.getGsonInstance().fromJson(motivator, listType);

            MotivatorModel.getInstance().notifyMotivatorLoaded(motivatorList);
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD

}
=======
}
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
