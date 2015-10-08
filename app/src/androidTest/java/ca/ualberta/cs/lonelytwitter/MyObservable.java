package ca.ualberta.cs.lonelytwitter;

/**
 * Created by victoria on 2015-10-07.
 */
public interface MyObservable {

    void notifyObservers();
    void addObserver(MyObserver o);

}
