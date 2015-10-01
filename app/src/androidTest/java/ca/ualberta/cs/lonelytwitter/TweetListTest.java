package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;


public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }
    /*

    public void testDeleteTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihi");
        tweetList.add(tweet);
        tweetList.delete(tweet);
        assertFalse(tweetList.hasTweet(tweet));

    }
    */

    public void testAddTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihi");
        tweetList.add(tweet);

        try {
            tweetList.add(tweet);
            fail();
        } catch(IllegalArgumentException e ) {

        }

    }

    public void testGetTweet(){

        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihi");
        tweetList.add(tweet);

        assertTrue(tweetList.hasTweet(tweet));
    }


    public void testGetTweets(){

        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihi");
        tweetList.add(tweet);
        Tweet tweet2 = new NormalTweet("hihi2");
        tweetList.add(tweet2);

        ArrayList<Tweet> t = tweetList.getTweets();

        assertTrue(tweetList.hasTweet(tweet));
    }



}