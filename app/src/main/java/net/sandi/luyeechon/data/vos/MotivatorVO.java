package net.sandi.luyeechon.data.vos;

/**
 * Created by Kaung Htet Lin on 9/23/2016.
 */
public class MotivatorVO {

    private String image;

    public MotivatorVO(String imgurl)
    {
        image=imgurl;
    }


    public String getImage() {
        return image;
    }
}