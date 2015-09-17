package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by victoria on 2015-09-16.
 */

public class NormalTweet extends Tweet implements Tweetable {

    public NormalTweet(Date date, String tweet) {
        super(date, tweet);
    }

    public NormalTweet(String tweet) {
        super(tweet);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }

    @Override
    public String getText(){
        return super.getText();
    }

}
