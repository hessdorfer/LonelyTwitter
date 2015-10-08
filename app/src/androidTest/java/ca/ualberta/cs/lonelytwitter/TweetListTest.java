package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;


public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver {

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

    private ArrayList<MyObservable> observables = new ArrayList<MyObservable>();
    private boolean wasNotified = false;
    public void addObservable(MyObservable myObservable){


    }

    public void testTweetListChanged(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hi");

        tweetList.addObserver(this);
        wasNotified = false;

        assertFalse(wasNotified);

        //
        tweetList.add(tweet);
        assertTrue(wasNotified);

    }

    public void myNotify(){
        wasNotified = true;

    }



}