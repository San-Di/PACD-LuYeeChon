package net.sandi.luyeechon.data;

/**
 * Created by UNiQUE on 9/18/2016.
 */
public class HealthVO {

    private String healthTitle;
    private String healthDes;
    private String image;

    public HealthVO(String healthTitle, String healthDes, String image) {
        this.healthTitle = healthTitle;
        this.healthDes = healthDes;
        this.image = image;
    }

    public HealthVO(String healthTitle, String healthDes) {
        this.healthTitle = healthTitle;
        this.healthDes = healthDes;
    }



    public String getHealthTitle() {
        return healthTitle;
    }

    public String getHealthDes() {
        return healthDes;
    }

    public String getImage() {
        return image;
    }
}
