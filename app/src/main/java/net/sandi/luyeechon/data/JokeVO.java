package net.sandi.luyeechon.data;

/**
 * Created by UNiQUE on 9/19/2016.
 */
public class JokeVO {
    private String jokeTitle;
    private String jokeDes;
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
