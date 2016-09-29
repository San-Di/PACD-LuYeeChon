package net.sandi.luyeechon.events;

import net.sandi.luyeechon.data.vos.MotivatorVO;
import net.sandi.luyeechon.data.vos.QuizVO;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class DataEvent {

    public static class MotivatorDataLoadedEvent {
        private String extraMessage;
        private List<MotivatorVO> quizList;

        public MotivatorDataLoadedEvent(String extraMessage, List<MotivatorVO> quizList) {
            this.extraMessage = extraMessage;
            this.quizList = quizList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<MotivatorVO> getQuizList() {
            return quizList;
        }
    }

    public static class QuizDataLoadEvent {
        private String extraMessage;
        private List<QuizVO> quizList;

        public QuizDataLoadEvent(String extraMessage, List<QuizVO> quizList) {
            this.extraMessage = extraMessage;
            this.quizList = quizList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<QuizVO> getQuizList() {
            return quizList;
        }
    }

}
