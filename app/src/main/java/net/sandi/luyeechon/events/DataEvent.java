package net.sandi.luyeechon.events;

import net.sandi.luyeechon.data.vos.MotivatorVO;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class DataEvent {

    public static class MotivatorDataLoadedEvent {
        private String extraMessage;
        private List<MotivatorVO> attractionList;

        public MotivatorDataLoadedEvent(String extraMessage, List<MotivatorVO> attractionList) {
            this.extraMessage = extraMessage;
            this.attractionList=attractionList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<MotivatorVO> getAttractionList() {
            return attractionList;
        }
    }

}
