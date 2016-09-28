package net.sandi.luyeechon.events;

<<<<<<< HEAD
import net.sandi.luyeechon.data.vos.HealthVO;
import net.sandi.luyeechon.data.vos.JokeVO;
=======
import net.sandi.luyeechon.data.vos.MotivatorVO;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54

import java.util.List;

/**
<<<<<<< HEAD
 * Created by UNiQUE on 9/25/2016.
 */
public class DataEvent {
    public static class HealthDataLoadedEvent{
        private String extraMessage;
        private List<HealthVO> healthList;

        public HealthDataLoadedEvent(String extraMessage, List<HealthVO> healthList) {
            this.extraMessage = extraMessage;
            this.healthList = healthList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<HealthVO> getHealthList() {
            return healthList;
        }
    }

    public static class JokeDataLoadedEvent{
        private String extraMessage;
        private List<JokeVO> jokeList;

        public JokeDataLoadedEvent(String extraMessage, List<JokeVO> jokeList) {
            this.extraMessage = extraMessage;
            this.jokeList = jokeList;
=======
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class DataEvent {

    public static class MotivatorDataLoadedEvent {
        private String extraMessage;
        private List<MotivatorVO> attractionList;

        public MotivatorDataLoadedEvent(String extraMessage, List<MotivatorVO> attractionList) {
            this.extraMessage = extraMessage;
            this.attractionList=attractionList;
>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
        }

        public String getExtraMessage() {
            return extraMessage;
        }

<<<<<<< HEAD
        public List<JokeVO> getJokeList() {
            return jokeList;
        }
    }
=======
        public List<MotivatorVO> getAttractionList() {
            return attractionList;
        }
    }

>>>>>>> dc9c1a1913df04362c5b8108bd4831d705192a54
}
