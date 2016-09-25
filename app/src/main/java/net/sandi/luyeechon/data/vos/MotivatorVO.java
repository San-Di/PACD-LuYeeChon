package net.sandi.luyeechon.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kaung Htet Lin on 9/23/2016.
 */
public class MotivatorVO {

    @SerializedName("image_url")
    private String image;

    public MotivatorVO(String imgurl)
    {
        image=imgurl;
    }


    public String getImage() {
        return image;
    }
}
