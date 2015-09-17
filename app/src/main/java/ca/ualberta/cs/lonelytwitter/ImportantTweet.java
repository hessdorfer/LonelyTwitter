package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by victoria on 2015-09-16.
 */
public class ImportantTweet extends Tweet implements Tweetable {

    // we get the attributes and getter/setter methods for free
    // not the constructors

    public ImportantTweet(Date date, String tweet) {
        super(date, tweet);
    }

    public ImportantTweet(String tweet) {
        super(tweet);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override
    public String getText(){
        return "!!!" + super.getText();
    }


}
