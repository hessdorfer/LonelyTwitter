package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by victoria on 2015-09-16.
 */
public abstract class Mood {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate() {
        this.date = new Date();
    }

    public String setMood(){
        return null;
    }
}
