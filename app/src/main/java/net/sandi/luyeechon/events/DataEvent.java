package net.sandi.luyeechon.events;

import net.sandi.luyeechon.data.vos.HealthVO;

import java.util.List;

/**
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

        public List<HealthVO> getAttractionList() {
            return healthList;
        }
    }
}
