package net.sandi.luyeechon.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by UNiQUE on 9/19/2016.
 */
public class JokeVO {

    @SerializedName("joke_title")
    private String jokeTitle;

    @SerializedName("joke_desc")
    private String jokeDes;

    @SerializedName("joke_photo")
    private String imageJoke;

    public JokeVO(String jokeTitle, String jokeDes, String imageJoke) {
        this.jokeTitle = jokeTitle;
        this.jokeDes = jokeDes;
        this.imageJoke = imageJoke;
    }

    public JokeVO(String jokeTitle, String jokeDes) {
        this.jokeTitle = jokeTitle;
        this.jokeDes = jokeDes;
    }

    public String getJokeTitle() {
        return jokeTitle;
    }

    public String getJokeDes() {
        return jokeDes;
    }

    public String getImageJoke() {
        return imageJoke;
    }
}
