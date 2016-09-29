package net.sandi.luyeechon.data.agents;

import com.google.gson.reflect.TypeToken;

import net.sandi.luyeechon.data.models.MotivatorModel;
import net.sandi.luyeechon.data.models.QuizModel;
import net.sandi.luyeechon.data.vos.MotivatorVO;
import net.sandi.luyeechon.data.vos.QuizVO;
import net.sandi.luyeechon.utils.CommonInstances;
import net.sandi.luyeechon.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class OfflineDataAgent implements LuYeeChonDataAgent {

    private static final String OFFLINE_MOTIVATOR_LIST = "motivator_list.json";

    private static final String OFFLINE_QUIZ_LIST="quiz_list.json";

    private static OfflineDataAgent objInstance;

    private OfflineDataAgent() {

    }

    public static OfflineDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new OfflineDataAgent();
        }

        return objInstance;
    }


    @Override
    public void loadMotivator() {
        try {
            String motivator = JsonUtils.getInstance().loadDummyData(OFFLINE_MOTIVATOR_LIST);
            Type listType = new TypeToken<List<MotivatorVO>>() {
            }.getType();
            List<MotivatorVO> motivatorList = CommonInstances.getGsonInstance().fromJson(motivator, listType);

            MotivatorModel.getInstance().notifyMotivatorLoaded(motivatorList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadQuiz() {
        try {
            String quiz = JsonUtils.getInstance().loadDummyData(OFFLINE_QUIZ_LIST);
            Type listType = new TypeToken<List<QuizVO>>() {
            }.getType();
            List<QuizVO> quizList = CommonInstances.getGsonInstance().fromJson(quiz, listType);

            QuizModel.getInstance().notifyQuizLoaded(quizList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}