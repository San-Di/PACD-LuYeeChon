package net.sandi.luyeechon.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by UNiQUE on 9/18/2016.
 */
public class HealthVO {

    @SerializedName("type")
    private String type;

    @SerializedName("health_title")
    private String healthTitle;

    @SerializedName("health_des")
    private String healthDes;

    @SerializedName("health_photo")
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

    public String getType() {
        return type;
    }
}
