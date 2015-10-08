package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by victoria on 2015-09-30.
 */
public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private ArrayList<MyObserver> myObservers = new ArrayList<MyObserver>();

    public void add(Tweet tweet){
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
        notifyObservers();
    }

    public void delete(Tweet tweet){
        return ;
    }

    public boolean hasTweet(Tweet tweet){

        return tweets.contains(tweet);

    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets(){
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.getDate().compareTo(rhs.getDate());

            }
        });
        return tweets;
    }

    public void addObserver(MyObserver observer){
        myObservers.add(observer);
    }

    public void notifyObservers(){
        for (MyObserver observer : myObservers){
            observer.myNotify();
        }
    }
}
