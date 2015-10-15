package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.*;
import android.view.View;
import android.app.Instrumentation;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private EditText bodyText;
    private Button saveButton;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }


    public void testEditTweet(){

        // when you call getActivity the sys will start up the app & the activity.
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();

        // reset the app to a known state
        activity.getTweets().clear();

        // add a tweet using UI

        bodyText = activity.getBodyText();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText("test Tweet");
            }
        });
        getInstrumentation().waitForIdleSync();

        // save it
        saveButton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();
            }
        });
        getInstrumentation().waitForIdleSync();


        // make sure the tweet has been added - use the UI to get it!!
        // ListView is describing the tweets on the screen
        final ListView oldTweetsList  = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);

        assertEquals("test Tweet", tweet.getText());

        // ------ Next Test ---------

        // click on the tweet to edit
        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetsList.getChildAt(0);
                oldTweetsList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync();

        // https://developer.android.com/training/activity-testing/activity-functional-testing.html Oct 14 2015

        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor = getInstrumentation().addMonitor(EditTweetActivity.class.getName(), null, false);
        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetsList.getChildAt(0);
                oldTweetsList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync();



        // Validate that ReceiverActivity is started
        //TouchUtils.clickView(this, sendToReceiverButton);
        final EditTweetActivity receiverActivity = (EditTweetActivity) receiverActivityMonitor.waitForActivityWithTimeout(1000);

        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called", 1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type", EditTweetActivity.class, receiverActivity.getClass());

        // Remove the ActivityMonitor
        //getInstrumentation().removeMonitor(receiverActivityMonitor);


        // 1. test that the editor starts up w the correct tweet in the edit

        // get tweet - don't know how yet?? 

        // check it's the right tweet
        final ListView oldTweetsList2  = activity.getOldTweetsList();
        tweet = (Tweet) oldTweetsList2.getItemAtPosition(0);

        assertEquals("test Tweet", tweet.getText());

        // 2. test that we can edit that old tweet

        // click on the tweet to edit
        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetsList.getChildAt(0);
                oldTweetsList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync();


        // 3. can push some kind of save button for that tweet

        saveButton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();
            }
        });
        getInstrumentation().waitForIdleSync();


        // 4. new modified tweet text was actually saved

        final ListView oldTweetsList3  = activity.getOldTweetsList();
        tweet = (Tweet) oldTweetsList3.getItemAtPosition(0);

        assertEquals("test Tweet", tweet.getText());

        // 5. new modified tweet text is displayed on the other activity



        // clean up your activities at the end of a UI test or else it will hang!!
        receiverActivity.finish();



    }

}