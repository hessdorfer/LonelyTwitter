package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by victoria on 2015-09-16.
 */

public abstract class Tweet {
    private String text;
    private Date date;

    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    public Tweet(Date date, String tweet) {
        this.date = date;
        this.setText(tweet);
    }

    public Tweet(String tweet) {
        this.setText(tweet);
        this.date = new Date(); // default to current date & time
    }

    public String getText() {
        return this.text;

    }

    public void addMood(Mood mood){
        this.moodList.add(mood);
    }

    public void setText(String text){
        if (text.length() <= 140){
            this.text = text;
        } else {
            throw new IllegalArgumentException("Tweet was toooo looooong!;");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTest(String text) {
        this.text = text;
    }

    abstract Boolean isImportant();

}
